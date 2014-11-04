package com.hnmmli.security.online.encryption;

import static org.junit.Assert.assertEquals;

public class PBE_EncryptionTest
{
    public static void main(String[] args)
    {
        try
        {
            String inputStr = "abc";
            System.err.println("原文: " + inputStr);
            byte[] input = inputStr.getBytes();

            String pwd = "efg";
            System.err.println("密码: " + pwd);

            byte[] salt = PBE_Encryption.initSalt();

            byte[] data = PBE_Encryption.encrypt(input, pwd, salt);

            System.err.println("加密后: " + PBE_Encryption.encryptByApacheBASE64(data));

            byte[] output = PBE_Encryption.decrypt(data, pwd, salt);
            String outputStr = new String(output);

            System.err.println("解密后: " + outputStr);
            assertEquals(inputStr, outputStr);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}