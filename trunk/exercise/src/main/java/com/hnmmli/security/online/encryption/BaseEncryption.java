package com.hnmmli.security.online.encryption;

import java.security.MessageDigest;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

public class BaseEncryption
{
    public static final String KEY_SHA = "SHA";

    public static final String KEY_MD5 = "MD5";

    /**
     * MAC算法可选以下多种算法
     * 
     * HmacMD5
     * HmacSHA1
     * HmacSHA256
     * HmacSHA384
     * HmacSHA512
     */
    public static final String KEY_MAC = "HmacMD5";

    /*
     * base64的编码都是按照字符的ascII码取二进制字节(byte)，之后按照3个字节为一个单位进行取组，每组24个比特(bit)
     * 然后再将这24个bit划分为4个6bit，并在每个6bit的字节前面都填两个高位0，重新获得4个字节(byte)
     * 然后将这4个字节转换成10进制，对照Base64编码表，得到对应编码后的字符。
     * Base64 编码表
     * Value-Char
     * 00-----A
     * 01-----B
     * 02-----C
     * 03-----D
     * 04-----E
     * 05-----F
     * 06-----G
     * 07-----H
     * 08-----I
     * 09-----J
     * 10-----K
     * 11-----L
     * 12-----M
     * 13-----N
     * 14-----O
     * 15-----P
     * 16-----Q
     * 17-----R
     * 18-----S
     * 19-----T
     * 20-----U
     * 21-----V
     * 22-----W
     * 23-----X
     * 24-----Y
     * 25-----Z
     * 26-----a
     * 27-----b
     * 28-----c
     * 29-----d
     * 30-----e
     * 31-----f
     * 32-----g
     * 33-----h
     * 34-----i
     * 35-----j
     * 36-----k
     * 37-----l
     * 38-----m
     * 39-----n
     * 40-----o
     * 41-----p
     * 42-----q
     * 43-----r
     * 44-----s
     * 45-----t
     * 46-----u
     * 47-----v
     * 48-----w
     * 49-----x
     * 50-----y
     * 51-----z
     * 52-----0
     * 53-----1
     * 54-----2
     * 55-----3
     * 56-----4
     * 57-----5
     * 58-----6
     * 59-----7
     * 60-----8
     * 61-----9
     * 62-----+
     * 63-----/
     * 
     * 步骤：
     * 甲方数据加密
     * 甲方向乙方发送加密数据
     * 乙方对数据解密
     */

    /**
     * 使用Base64加密算法加密字符串
     */
    public static String encryptByApacheBASE64(byte[] source)
    {
        Base64 base64 = new Base64();
        return new String(base64.encode(source));
    }

    /**
     * 
     * 使用Base64解密
     */
    public static byte[] decryptByApacheBASE64(String key)
    {
        Base64 base64 = new Base64();
        return base64.decode(key.getBytes());
    }

    /*
     * MD5 -- message-digest algorithm 5 （信息-摘要算法）缩写，常用于文件校验。不管文件多大，经过MD5后都能生成唯一的MD5值。
     * MD5是输入不定长度信息，输出固定长度128-bits的算法。经过程序流程，生成四个int数据，最后联合起来成为一个128-bits散列。
     * 基本方式为，求余、取余、调整长度、与链接变量进行循环运算。得出结果。
     * 第一步、填充：如果输入信息的长度(bit)对512求余的结果不等于448，就需要填充使得对512求余的结果等于448。填充的方法是填充
     * 一个1和n个0。填充完后，信息的长度就为N*512+448(bit)；
     * 第二步、记录信息长度：用64位来存储填充前信息长度。这64位加在第一步结果的后面，这样信息长度就变为N*512+448+64=(N+1)*512位。
     * 第三步、装入标准的幻数（四个整数）：标准的幻数（物理顺序）是（A=(01234567)16，B=(89ABCDEF)16，C=(FEDCBA98)16，
     * D=(76543210)16）。如果在程序中定义应该是（A=0X67452301L，B=0XEFCDAB89L，C=0X98BADCFEL，D=0X10325476L）。
     * 第四步、四轮循环运算：循环的次数是分组的个数（N+1） 得出4个int数值组装成128位bit数值
     * 
     * 步骤：
     * 甲方公布信息摘要算法
     * 甲方对数据做信息摘要处理
     * 甲方向乙方发送原始数据，信息摘要
     * 乙方对原始数据做摘要处理
     * 乙方校验摘要信息是否一致
     */

    /**
     * MD5加密
     * 
     * @param data
     * @return
     * @throws Exception
     */
    public static byte[] encryptMD5(byte[] data) throws Exception
    {
        MessageDigest md5 = MessageDigest.getInstance(KEY_MD5);
        md5.update(data);
        return md5.digest();
    }

    /*
     * SHA-1(Secure Hash Algorithm，安全散列算法），数字签名等密码学应用中重要的工具，被广泛地应用于电子商务等信息安全领域。
     * SHA是公认的安全加密算法，较之MD5更为安全。
     * SHA-1，SHA-224和SHA-256适用于长度不超过2^64二进制位的消息。SHA-384和SHA-512适用于长度不超过2^128二进制位的消息。
     * 
     * 步骤：
     * 甲方公布信息摘要算法
     * 甲方对数据做信息摘要处理
     * 甲方向乙方发送原始数据，信息摘要
     * 乙方对原始数据做摘要处理
     * 乙方校验摘要信息是否一致
     */

    /**
     * SHA-1加密
     * 
     * @param data
     * @return
     * @throws Exception
     */
    public static byte[] encryptSHA(byte[] data) throws Exception
    {
        MessageDigest sha = MessageDigest.getInstance(KEY_SHA);
        sha.update(data);
        return sha.digest();
    }

    /*
     * 计算HMAC需要一个散列函数hash（可以是md5或者sha-1，表示为H）和一个密钥key表示为K。用L表示hash函数输出字符串长（md5是16），
     * 用B表示数据块的长度（md5和sha-1的分割数据块长都是64）。K的长度可以小于等于数据块长B，如果大于数据块长度，
     * 可以使用hash函数对key进行转换，结果就是一个L长的key。
     * 
     * 步骤：
     * 甲方构建密钥
     * 甲方向乙方发送密钥
     * 甲方使用密钥对数据做信息摘要处理
     * 甲方向乙方发送原始数据，信息摘要
     * 乙方使用密钥对原始数据做摘要处理
     * 乙方校验摘要信息是否一致
     */

    /**
     * 初始化HMAC密钥
     * 
     * @return
     * @throws Exception
     */
    public static String initMacKey() throws Exception
    {
        KeyGenerator keyGenerator = KeyGenerator.getInstance(KEY_MAC);

        SecretKey secretKey = keyGenerator.generateKey();
        return encryptByApacheBASE64(secretKey.getEncoded());
    }

    /**
     * HMAC加密
     * 
     * @param data
     * @param key
     * @return
     * @throws Exception
     */
    public static byte[] encryptHMAC(byte[] data, String key) throws Exception
    {

        SecretKey secretKey = new SecretKeySpec(decryptByApacheBASE64(key), KEY_MAC);
        Mac mac = Mac.getInstance(secretKey.getAlgorithm());
        mac.init(secretKey);

        return mac.doFinal(data);

    }
}
