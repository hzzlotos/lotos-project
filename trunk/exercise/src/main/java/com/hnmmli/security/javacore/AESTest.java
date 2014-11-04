package com.hnmmli.security.javacore;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.security.GeneralSecurityException;
import java.security.Key;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

/**
 * This program tests the AES cipher. Usage:<br>
 * java AESTest -genkey keyfile<br>
 * java AESTest -encrypt plaintext encrypted keyfile<br>
 * java AESTest -decrypt encrypted decrypted keyfile<br>
 * 
 * @author Cay Horstmann
 * @version 1.0 2004-09-14
 */
public class AESTest
{
    public static void main(String[] args)
    {
        boolean z = true;
        z = false;
        try
        {
            if (z)
            {
                KeyGenerator keygen = KeyGenerator.getInstance("AES");
                SecureRandom random = new SecureRandom();
                keygen.init(random);
                SecretKey key = keygen.generateKey();
                ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("G:/testkey.txt"));
                out.writeObject(key);
                out.close();
            }
            else
            {
                int mode;
                z = true;
                if (z)
                {
                    mode = Cipher.ENCRYPT_MODE;
                }
                else
                {
                    mode = Cipher.DECRYPT_MODE;
                }

                ObjectInputStream keyIn = new ObjectInputStream(new FileInputStream("G:/testkey.txt"));
                Key key = (Key) keyIn.readObject();
                keyIn.close();

                InputStream in = new FileInputStream("G:/test.txt");
                OutputStream out = new FileOutputStream("G:/test2.txt");
                Cipher cipher = Cipher.getInstance("AES");
                cipher.init(mode, key);

                crypt(in, out, cipher);
                in.close();
                out.close();
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Uses a cipher to transform the bytes in an input stream and sends the transformed bytes to an
     * output stream.
     * 
     * @param in the input stream
     * @param out the output stream
     * @param cipher the cipher that transforms the bytes
     */
    public static void crypt(InputStream in, OutputStream out, Cipher cipher) throws IOException,
            GeneralSecurityException
    {
        int blockSize = cipher.getBlockSize();
        int outputSize = cipher.getOutputSize(blockSize);
        byte[] inBytes = new byte[blockSize];
        byte[] outBytes = new byte[outputSize];

        int inLength = 0;
        boolean more = true;
        while (more)
        {
            inLength = in.read(inBytes);
            if (inLength == blockSize)
            {
                int outLength = cipher.update(inBytes, 0, blockSize, outBytes);
                out.write(outBytes, 0, outLength);
            }
            else
            {
                more = false;
            }
        }
        if (inLength > 0)
        {
            outBytes = cipher.doFinal(inBytes, 0, inLength);
        }
        else
        {
            outBytes = cipher.doFinal();
        }
        out.write(outBytes);
    }
}
