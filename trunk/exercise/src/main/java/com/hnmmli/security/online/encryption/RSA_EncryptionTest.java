package com.hnmmli.security.online.encryption;

import java.util.Map;

public class RSA_EncryptionTest
{
    private static String publicKey;

    private static String privateKey;

    public static void main(String[] args)
    {
        try
        {
            createKey();
            System.out.println("**************************************");
            test();
            System.out.println("**************************************");
            testSign();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private static void createKey() throws Exception
    {
        Map<String, Object> keyMap = RSA_Encryption.initKey();

        publicKey = RSA_Encryption.getPublicKey(keyMap);
        privateKey = RSA_Encryption.getPrivateKey(keyMap);
        System.out.println("公钥: \n" + publicKey);
        System.out.println("私钥： \n" + privateKey);
    }

    private static void test() throws Exception
    {
        System.out.println("公钥加密——私钥解密");
        String inputStr = "abc";
        byte[] data = inputStr.getBytes();

        byte[] encodedData = RSA_Encryption.encryptByPublicKey(data, publicKey);

        byte[] decodedData = RSA_Encryption.decryptByPrivateKey(encodedData, privateKey);

        String outputStr = new String(decodedData);
        System.out.println("加密前: " + inputStr + "\n" + "解密后: " + outputStr);

    }

    private static void testSign() throws Exception
    {
        System.out.println("私钥加密——公钥解密");
        String inputStr = "sign";
        byte[] data = inputStr.getBytes();

        byte[] encodedData = RSA_Encryption.encryptByPrivateKey(data, privateKey);

        byte[] decodedData = RSA_Encryption.decryptByPublicKey(encodedData, publicKey);

        String outputStr = new String(decodedData);
        System.out.println("加密前: " + inputStr + "\n\r" + "解密后: " + outputStr);

        System.out.println("私钥签名——公钥验证签名");
        // 产生签名
        String sign = RSA_Encryption.sign(encodedData, privateKey);
        System.out.println("签名:\r" + sign);

        // 验证签名
        boolean status = RSA_Encryption.verify(encodedData, publicKey, sign);
        System.out.println("状态:\r" + status);
    }
}