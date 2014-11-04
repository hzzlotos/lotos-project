package com.hnmmli.security.online.encryption;

public class Certificate_EncryptionTest
{
    private static String password        = "123456";

    private static String alias           = "www.hzz.com";

    private static String certificatePath = "e:/hzz.cer";

    private static String keyStorePath    = "e:/hzz.keystore";

    public static void main(String[] args)
    {
        try
        {
            System.out.println("公钥加密——私钥解密");
            String inputStr = "Ceritifcate";
            byte[] data = inputStr.getBytes();
            byte[] encrypt = Certificate_Encryption.encryptByPublicKey(data, certificatePath);
            byte[] decrypt = Certificate_Encryption.decryptByPrivateKey(encrypt, keyStorePath, alias, password);
            String outputStr = new String(decrypt);
            System.out.println("加密前: " + inputStr + "\n" + "解密后: " + outputStr);
            System.out.println("***********************************************************");
            testSign();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void testSign() throws Exception
    {
        System.out.println("私钥加密——公钥解密");
        String inputStr = "sign";
        byte[] data = inputStr.getBytes();
        byte[] encodedData = Certificate_Encryption.encryptByPrivateKey(data, keyStorePath, alias, password);
        byte[] decodedData = Certificate_Encryption.decryptByPublicKey(encodedData, certificatePath);
        String outputStr = new String(decodedData);
        System.out.println("加密前: " + inputStr + "\n" + "解密后: " + outputStr);
        // 产生签名
        String sign = Certificate_Encryption.sign(encodedData, keyStorePath, alias, password);
        System.out.println("签名:\r" + sign);
        // 验证签名
        boolean status = Certificate_Encryption.verify(encodedData, sign, certificatePath);
        System.out.println("状态:\r" + status);
    }
}
