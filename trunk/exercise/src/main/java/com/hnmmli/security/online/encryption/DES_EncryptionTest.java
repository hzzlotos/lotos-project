package com.hnmmli.security.online.encryption;

public class DES_EncryptionTest
{
    public static void main(String[] args)
    {
        try
        {
            String inputStr = "DES";
            String key = DES_Encryption.initKey();
            byte[] inputData = inputStr.getBytes();
            inputData = DES_Encryption.encrypt(inputData, key, true);
            byte[] outputData = DES_Encryption.decrypt(inputData, key, true);
            String outputStr = new String(outputData);
            System.out.println("原文：" + inputStr);

            System.out.println("密钥：" + key);
            for (Byte b : inputData)
            {
                System.out.print(b + " ");
            }
            System.out.println();
            System.out.println("解密：" + outputStr);
            System.out.println("------------");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}