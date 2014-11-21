package javacore.security.online.encryption;

import java.util.Map;

public class ECC_EncryptionTest
{

    public static void main(String[] args)
    {
        try
        {
            String inputStr = "123asd";
            byte[] data = inputStr.getBytes();

            Map<String, Object> keyMap = ECC_Encryption.initKey();

            String publicKey = ECC_Encryption.getPublicKey(keyMap);
            String privateKey = ECC_Encryption.getPrivateKey(keyMap);
            System.err.println("公钥: \n" + publicKey);
            System.err.println("私钥： \n" + privateKey);

            byte[] encodedData = ECC_Encryption.encrypt(data, publicKey);

            byte[] decodedData = ECC_Encryption.decrypt(encodedData, privateKey);

            String outputStr = new String(decodedData);
            System.err.println("加密前: " + inputStr + "\n\r" + "解密后: " + outputStr);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
