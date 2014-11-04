package com.hnmmli.security.online.encryption;

import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.Cipher;

public class RSA_Encryption extends BaseEncryption
{

    /*
     * 
     * 简介：
     * -------------------------------------------------------------------
     * 前置知识：
     * 『mod指取余，即计算机中的取模』
     * 一.互质关系
     * 如果两个正整数，除了1以外，没有其他公因子，我们就称这两个数是互质关系（coprime）。比如，15和32没有公因子，
     * 所以它们是互质关系。这说明，不是质数也可以构成互质关系。
     * ===============================================================
     * 二.欧拉函数
     * 任意给定正整数n，请问在小于等于n的正整数之中，有多少个数与n构成互质关系？ 计算这个值的方法就叫做欧拉函数，以φ(n)表示。
     * 例如在1到8之中，与8形成互质关系的是1、3、5、7，所以 φ(n) = 4。
     * (1)第一种情况
     * 如果n=1，则 φ(1) = 1 因为1与任何数（包括自身）都构成互质关系。
     * (2)第二种情况
     * 如果n是质数，则 φ(n)=n-1 因为质数与小于它的每一个数，都构成互质关系。比如5与1、2、3、4都构成互质关系。
     * (3)第三种情况
     * 如果n是质数的某一个次方，即 n = (p^k) (p为质数，k为大于等于1的整数)，则φ(n)=(p^k) - (p^(k-1))
     * 比如 φ(8) = φ(2^3) =2^3 - 2^2 = 8 -4 = 4
     * (4)第四种情况
     * 如果n可以分解成两个互质的整数之积， n = p1 * p2 则 φ(n) = φ(p1*p2) = φ(p1) * φ(p2)
     * (5) 第五种情况
     * 因为任意一个大于1的正整数，都可以写成一系列质数的积。 n=(p1^k1)*(p2^k2)...(pr^kr)
     * 得到 φ(n)=n*(1-1/p1)*(1-1/p2)...(1-1/pr)
     * ===============================================================
     * 三、欧拉定理
     * a^φ(n) ≡ 1 mod (n)
     * a的φ(n)次方被n除的余数为1。或者说，a的φ(n)次方减去1，可以被n整除。
     * 比如，3和7互质，而7的欧拉函数φ(7)等于6，所以3的6次方（729）减去1，可以被7整除（728/7=104）。
     * 
     * 欧拉定理有一个特殊情况。 正整数a与质数p互质，因为质数p的φ(p)等于p-1，则欧拉定理可以写成
     * a^(p-1) ≡ 1 mod (n)
     * 这就是著名的费马小定理。它是欧拉定理的特例。
     * ===================================================
     * 四、模反元素
     * a*b ≡ 1 ( mod (n)) 『b为a关于n的模反元素』
     * 如果两个正整数a和n互质，那么一定可以找到整数b，使得 a*b-1 被n整除，或者说a*b被n除的余数是1。
     * -------------------------------------------------------------------
     * 
     * 生成密钥：
     * 第一步，随机选择两个不相等的质数p和q。
     * 选择p=61，q=53。
     * 第二步，计算p和q的乘积n。
     * 则n=3233。
     * 第三步，计算n的欧拉函数φ(n)。根据公式所得φ(n) = (p-1)*(q-1)
     * 则φ(n)=φ(3233)=60*52=3120。
     * 第四步，随机选择一个整数e，条件是1< e < φ(n)，且e与φ(n) 互质。
     * 随机选择e=17。
     * 第五步，计算e对于φ(n)的模反元素d。
     * 由e=17，φ(n)=3120，算出一组整数解为 (x,y)=(2753,-15)，即 d=2753。
     * 第六步，将n和e封装成公钥，n和d封装成私钥。
     * 例子中，n=3233，e=17，d=2753，所以公钥就是 (3233,17)，私钥就是（3233, 2753）。
     * 加密：
     * 使用公钥 (n,e)机密，假设需发送信息为m，用公钥 (n,e) 对m进行加密。m必须是整数（字符串可以取ascii值或unicode值），且m必须小于n。
     * 所谓"加密"，就是算出下式的c：m^e ≡ c (mod n)；加密数据即为c
     * 公钥是 (3233, 17)，即n=3233，e=17，假设m是65，则：65^17 ≡ c (mod 3233) => c=2790。
     * 解密：
     * 使用私钥(n,d)解密，在拿到公钥加密过后的加密数据c之后使用公式c^d ≡ m (mod n)求得原m
     * 私钥是(3233, 2753)，即n=3233，d=2753，而c=2790，则2790^2753 ≡ m (mod 3233) => m = 65。
     * 至此，"加密--解密"的整个过程全部完成。
     * 
     * 私钥解密的证明：
     * 为什么用私钥解密，一定可以正确地得到m。也就是证明下面这个式子cd ≡ m (mod n)
     * 
     * 加密所用公式加密规则m^e ≡ c (mod n)
     * 于是可以得到c = m^e - kn
     * 将c代入要我们要证明的那个解密规则：(m^e - k*n)^d ≡ m (mod n)，等同于求证 m^(e*d) ≡ m (mod n)
     * 由于e*d ≡ 1 (mod φ(n))，所以e*d = hφ(n)+1，将e*d代入得到
     * m^(hφ(n)+1) ≡ m (mod n)，下面分成两种情况证明上面这个式子。
     * （1）m与n互质
     * 根据欧拉定理 m^φ(n) ≡ 1 (mod n) 得到(m^φ(n))^h*m ≡ m (mod n)
     * （2）m与n不是互质关系
     * 此时，由于n等于质数p和q的乘积，所以m必然等于k*p或k*q。
     * 以 m = k*p为例，考虑到这时k与q必然互质，则根据欧拉定理，下面的式子成立：(k*p)^(q-1) ≡ 1 (mod q)
     * 进一步得到((k*p)^(q-1))^(h*(p-1))*(k*p) ≡ k*p (mod q)；即 (k*p)^(e*d) ≡ k*p (mod q)
     * 将其改写成下面的等式 (k*p)^(e*d) = t*q + k*p，这时t必然能被p整除，即 t=z*p => (k*p)^(e*d) = z*p*q + k*p
     * 因为 m=k*p，n=p*q，所以 m^(e*d) ≡ m (mod n)
     * 
     * 
     * 
     * 步骤：
     * 甲方构建密钥对
     * 甲方公布公钥
     * 
     * 场景一：
     * 甲方使用私钥加密数据
     * 甲方使用私钥对机密过后的数据签名
     * 甲方向乙方发送加密数据，数字签名
     * 乙方使用公钥，签名验证带解密的数据
     * 乙方使用公钥解密数据
     * 
     * 场景二：
     * 乙方使用公钥加密数据
     * 乙方向甲方传送加密数据
     * 甲方使用私钥解密数据
     */

    public static final String  KEY_ALGORITHM       = "RSA";

    public static final String  SIGNATURE_ALGORITHM = "MD5withRSA";

    private static final String PUBLIC_KEY          = "RSAPublicKey";

    private static final String PRIVATE_KEY         = "RSAPrivateKey";

    /**
     * 用私钥对信息生成数字签名
     * 
     * @param data
     *            加密数据
     * @param privateKey
     *            私钥
     * 
     * @return
     * @throws Exception
     */
    public static String sign(byte[] data, String privateKey) throws Exception
    {
        // 解密由base64编码的私钥
        byte[] keyBytes = decryptByApacheBASE64(privateKey);

        // 构造PKCS8EncodedKeySpec对象
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);

        // KEY_ALGORITHM 指定的加密算法
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);

        // 取私钥匙对象
        PrivateKey priKey = keyFactory.generatePrivate(pkcs8KeySpec);

        // 用私钥对信息生成数字签名
        Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
        signature.initSign(priKey);
        signature.update(data);

        return encryptByApacheBASE64(signature.sign());
    }

    /**
     * 校验数字签名
     * 
     * @param data
     *            加密数据
     * @param publicKey
     *            公钥
     * @param sign
     *            数字签名
     * 
     * @return 校验成功返回true 失败返回false
     * @throws Exception
     * 
     */
    public static boolean verify(byte[] data, String publicKey, String sign) throws Exception
    {

        // 解密由base64编码的公钥
        byte[] keyBytes = decryptByApacheBASE64(publicKey);

        // 构造X509EncodedKeySpec对象
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);

        // KEY_ALGORITHM 指定的加密算法
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);

        // 取公钥匙对象
        PublicKey pubKey = keyFactory.generatePublic(keySpec);

        Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
        signature.initVerify(pubKey);
        signature.update(data);

        // 验证签名是否正常
        return signature.verify(decryptByApacheBASE64(sign));
    }

    /**
     * 解密<br>
     * 用私钥解密
     * 
     * @param data
     * @param key
     * @return
     * @throws Exception
     */
    public static byte[] decryptByPrivateKey(byte[] data, String key) throws Exception
    {
        // 对密钥解密
        byte[] keyBytes = decryptByApacheBASE64(key);

        // 取得私钥
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        Key privateKey = keyFactory.generatePrivate(pkcs8KeySpec);

        // 对数据解密
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.DECRYPT_MODE, privateKey);

        return cipher.doFinal(data);
    }

    /**
     * 解密<br>
     * 用公钥解密
     * 
     * @param data
     * @param key
     * @return
     * @throws Exception
     */
    public static byte[] decryptByPublicKey(byte[] data, String key) throws Exception
    {
        // 对密钥解密
        byte[] keyBytes = decryptByApacheBASE64(key);

        // 取得公钥
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        Key publicKey = keyFactory.generatePublic(x509KeySpec);

        // 对数据解密
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.DECRYPT_MODE, publicKey);

        return cipher.doFinal(data);
    }

    /**
     * 加密<br>
     * 用公钥加密
     * 
     * @param data
     * @param key
     * @return
     * @throws Exception
     */
    public static byte[] encryptByPublicKey(byte[] data, String key) throws Exception
    {
        // 对公钥解密
        byte[] keyBytes = decryptByApacheBASE64(key);

        // 取得公钥
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        Key publicKey = keyFactory.generatePublic(x509KeySpec);

        // 对数据加密
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        return cipher.doFinal(data);
    }

    /**
     * 加密<br>
     * 用私钥加密
     * 
     * @param data
     * @param key
     * @return
     * @throws Exception
     */
    public static byte[] encryptByPrivateKey(byte[] data, String key) throws Exception
    {
        // 对密钥解密
        byte[] keyBytes = decryptByApacheBASE64(key);

        // 取得私钥
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        Key privateKey = keyFactory.generatePrivate(pkcs8KeySpec);

        // 对数据加密
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.ENCRYPT_MODE, privateKey);

        return cipher.doFinal(data);
    }

    /**
     * 取得私钥
     * 
     * @param keyMap
     * @return
     * @throws Exception
     */
    public static String getPrivateKey(Map<String, Object> keyMap) throws Exception
    {
        Key key = (Key) keyMap.get(PRIVATE_KEY);

        return encryptByApacheBASE64(key.getEncoded());
    }

    /**
     * 取得公钥
     * 
     * @param keyMap
     * @return
     * @throws Exception
     */
    public static String getPublicKey(Map<String, Object> keyMap) throws Exception
    {
        Key key = (Key) keyMap.get(PUBLIC_KEY);

        return encryptByApacheBASE64(key.getEncoded());
    }

    /**
     * 初始化密钥
     * 
     * @return
     * @throws Exception
     */
    public static Map<String, Object> initKey() throws Exception
    {
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance(KEY_ALGORITHM);
        keyPairGen.initialize(1024);

        KeyPair keyPair = keyPairGen.generateKeyPair();

        // 公钥
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();

        // 私钥
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();

        Map<String, Object> keyMap = new HashMap<String, Object>(2);

        keyMap.put(PUBLIC_KEY, publicKey);
        keyMap.put(PRIVATE_KEY, privateKey);
        return keyMap;
    }
}