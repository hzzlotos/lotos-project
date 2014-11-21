package javacore.security.online.encryption;

import java.security.Key;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.SecretKeySpec;

public class DES_Encryption extends BaseEncryption
{
    /*
     * 简介：
     * DES是一种分组加密算法,明文和密文都为8个字节(64个bit)
     * 加密与解密除密钥编排不同外,使用的是同一算法
     * DES的安全性不依赖于算法的保密,安全性仅以加密密钥的保密为基础
     * 密钥可为任意的56位数,具有复杂性
     * 采用替代和置换的组合,共16轮
     * 只是用了标准的算术与逻辑运算,易于实现
     * ----------------------------------------------------------------------------------------
     * 算法原理：
     * DES算法把64位的明文输入块变为64位的密文输出块，它所使用的密钥也是64位，首先，DES把输入的64位数据块按位重新组合，
     * 并把输出分为L0、R0两部分，每部分各长32位，并进行前后置换（输入的第58位换到第一位，第50位换到第2位，依此类推，
     * 最后一位是原来的第7位），最终由L0输出左32位，R0输出右32位，根据这个法则经过16次迭代运算后，得到L16、R16，将此作为输入，
     * 进行与初始置换相反的逆置换，即得到密文输出。
     * ---------------------------------------------------------------------------------------
     * 两种模式的差别：
     * ECB模式：
     * 优点：
     * 1. 简单；
     * 2. 有利于并行计算；
     * 3. 误差不会被传递；
     * 缺点：
     * 1. 不能隐藏明文的模式；
     * 2. 可能对明文进行主动攻击；
     * 
     * DES ECB（电子密本方式）其实非常简单，就是将数据按照8个字节一段进行DES加密或解密得到一段段的8个字节的密文或者明文，
     * 最后一段不足8个字节（一般补0或者F），按照需求补足8个字节进行计算（并行计算），
     * 之后按照顺序将计算所得的数据连在一起即可，各段数据之间互不影响。
     * 
     * CBC模式：
     * 优点：
     * 1. 不容易主动攻击，安全性好于ECB，是SSL、IPSec的标准；
     * 缺点：
     * 1. 不利于并行计算；
     * 2. 误差传递；
     * 3. 需要初始化向量IV；
     * 
     * DES CBC（密文分组链接方式）有点麻烦，它的实现机制使加密的各段数据之间有了联系。其实现的机理如下：
     * 加密步骤如下：
     * 1. 首先将数据按照8个字节一组进行分组得到D1D2......Dn（若数据不是8的整数倍，用指定的PADDING数据补位）
     * 2. 第一组数据D1与初始化向量I异或后的结果进行DES加密得到第一组密文C1（初始化向量I为全零）
     * 3. 第二组数据D2与第一组的加密结果C1异或以后的结果进行DES加密，得到第二组密文C2
     * 4. 之后的数据以此类推，得到Cn
     * 5. 按顺序连为C1C2C3......Cn即为加密结果。
     * --------------------------------------------------------------------------
     * 
     * 步骤：
     * 甲方构建密钥
     * 甲方向乙方公布密钥
     * 甲方使用密钥对数据进行加密
     * 甲方向乙方发送加密数据
     * 乙方使用密钥对数据解密
     * 
     * 其实DES有很多同胞兄弟，如DESede(TripleDES)、AES、Blowfish、RC2、RC4(ARCFOUR)。这里就不过多阐述了，大同小异，
     * 只要换掉ALGORITHM换成对应的值，同时做一个代码替换SecretKey
     * secretKey = new SecretKeySpec(key, ALGORITHM);就可以了，此外就是密钥长度不同了。
     */

    /*
     * ALGORITHM可替换为以下任意一种，同时key值的size相应改变。
     * DES key size must be equal to 56
     * DESede(TripleDES) key size must be equal to 112 or 168
     * AES key size must be equal to 128, 192 or 256,but 192 and 256 bits may not be available
     * Blowfish key size must be multiple of 8, and can only range from 32 to 448 (inclusive)
     * RC2 key size must be between 40 and 1024 bits
     * RC4(ARCFOUR) key size must be between 40 and 1024 bits
     */
    public static final String ALGORITHM = "DES";

    /**
     * 转换密钥<br>
     * 
     * @param key
     * @return
     * @throws Exception
     */
    private static Key toKey(byte[] key, boolean isDES) throws Exception
    {
        DESKeySpec dks = new DESKeySpec(key);
        SecretKey secretKey;
        if (isDES)
        {
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(ALGORITHM);
            secretKey = keyFactory.generateSecret(dks);
        }
        else
        {
            // 当使用其他对称加密算法时，如AES、Blowfish等算法时
            secretKey = new SecretKeySpec(key, ALGORITHM);
        }
        return secretKey;
    }

    /**
     * 解密
     * 
     * @param data
     * @param key
     * @return
     * @throws Exception
     */
    public static byte[] decrypt(byte[] data, String key, boolean isDES) throws Exception
    {
        Key k = toKey(decryptByApacheBASE64(key), isDES);

        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, k);

        return cipher.doFinal(data);
    }

    /**
     * 加密
     * 
     * @param data
     * @param key
     * @return
     * @throws Exception
     */
    public static byte[] encrypt(byte[] data, String key, boolean isDES) throws Exception
    {
        Key k = toKey(decryptByApacheBASE64(key), isDES);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, k);

        return cipher.doFinal(data);
    }

    /**
     * 生成密钥
     * 
     * @return
     * @throws Exception
     */
    public static String initKey() throws Exception
    {
        return initKey(null);
    }

    /**
     * 生成密钥
     * 
     * @param seed
     * @return
     * @throws Exception
     */
    public static String initKey(String seed) throws Exception
    {
        SecureRandom secureRandom = null;

        if (seed != null)
        {
            secureRandom = new SecureRandom(decryptByApacheBASE64(seed));
        }
        else
        {
            secureRandom = new SecureRandom();
        }

        KeyGenerator kg = KeyGenerator.getInstance(ALGORITHM);
        kg.init(secureRandom);

        SecretKey secretKey = kg.generateKey();

        return encryptByApacheBASE64(secretKey.getEncoded());
    }
}
