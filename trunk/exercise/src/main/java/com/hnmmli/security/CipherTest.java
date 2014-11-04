package com.hnmmli.security;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class CipherTest
{
    public static void main(String[] args)
    {
        try
        {
            KeyGenerator keygen = KeyGenerator.getInstance("AES");
            SecureRandom random = new SecureRandom();
            keygen.init(random);
            SecretKey key = keygen.generateKey();
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            CipherOutputStream out = new CipherOutputStream(new FileOutputStream("G:/ciphertest.txt"), cipher);
            byte[] bytes = new byte[1024];
            int inLength = 0;// getData(bytes);
            while (inLength != -1)
            {
                out.write(bytes, 0, inLength);
                inLength = 0;// getData(bytes);
            }
            out.flush();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private void jiemi()
    {
        try
        {
            KeyGenerator keygen = KeyGenerator.getInstance("AES");
            SecureRandom random = new SecureRandom();
            keygen.init(random);
            SecretKey key = keygen.generateKey();
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            CipherInputStream in = new CipherInputStream(new FileInputStream(""), cipher);
            byte[] bytes = new byte[1024];
            int inLength = in.read(bytes);
            while (inLength != -1)
            {
                // putData(bytes,inLength);
                inLength = in.read(bytes);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}