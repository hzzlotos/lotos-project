package com.hnmmli.security.online.encryption;

import java.security.Key;
import java.util.Random;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;

public abstract class PBE_Encryption extends BaseEncryption
{

    /*
     * 
     * 简介：
     * PBE算法（Password Base Encryption，基于口令加密）算法是一种基于口令的加密算法。特点在于口令由用户自己掌握，采用随机数
     * （我们这里叫做 盐）杂凑多重加密等方法保证数据的安全性。PBE算法没有密钥的概念，把口令当做密钥了。因为密钥长短影响算法安全性，
     * 还不方便记忆，这里我们直接换成我们自己常用的口令就大大不同了，便于我们的记忆。但是单纯的口令很容易被字典法给穷举出来，
     * 所以我们这里给口令加了点“盐”，这个盐和口令组合，想破解就难了。同时我们将盐和口令合并后用消息摘要算法进行迭代很多次来
     * 构建密钥初始化向量的基本材料，使破译更加难了。PBE算法没构建新的加密算法，就是用了我们常用的对称加密算法，例如AES,DES等算法。
     * 
     * 
     * 
     * 步骤：
     * 甲方公布密码
     * 甲方构建盐
     * 甲方使用密码与 盐对数据加密
     * 甲方向乙方发送盐与加密数据
     * 乙方使用密码与盐对数据解密
     * 
     * 
     * 
     * 支持以下任意一种算法
     * PBEWithMD5AndDES
     * PBEWithMD5AndTripleDES
     * PBEWithSHA1AndDESede
     * PBEWithSHA1AndRC2_40
     */
    public static final String ALGORITHM = "PBEWITHMD5andDES";

    /**
     * 盐初始化
     * 
     * @return
     * @throws Exception
     */
    public static byte[] initSalt() throws Exception
    {
        byte[] salt = new byte[8];
        Random random = new Random();
        random.nextBytes(salt);
        return salt;
    }

    /**
     * 转换密钥
     * 
     * @param password
     * @return
     * @throws Exception
     */
    private static Key toKey(String password) throws Exception
    {
        PBEKeySpec keySpec = new PBEKeySpec(password.toCharArray());
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(ALGORITHM);
        SecretKey secretKey = keyFactory.generateSecret(keySpec);
        return secretKey;
    }

    /**
     * 加密
     * 
     * @param data 数据
     * @param password 密码
     * @param salt 盐
     * @return byte[] 加密之后字符串的btye数组
     * @throws Exception
     */
    public static byte[] encrypt(byte[] data, String password, byte[] salt) throws Exception
    {

        Key key = toKey(password);
        PBEParameterSpec paramSpec = new PBEParameterSpec(salt, 100);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, key, paramSpec);
        return cipher.doFinal(data);

    }

    /**
     * 解密
     * 
     * @param data 数据
     * @param password 密码
     * @param salt 盐
     * @return byte[] 解密之后字符串的btye数组
     * @throws Exception
     */
    public static byte[] decrypt(byte[] data, String password, byte[] salt) throws Exception
    {

        Key key = toKey(password);
        PBEParameterSpec paramSpec = new PBEParameterSpec(salt, 100);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, key, paramSpec);
        return cipher.doFinal(data);
    }
}