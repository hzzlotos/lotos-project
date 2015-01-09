package javacore.security.online.encryption;

import java.util.Map;

public class DSA_EncryptionTest
{

    public static void main(String[] args)
    {
        try
        {
            String inputStr = "abc";
            byte[] data = inputStr.getBytes();

            // 构建密钥
            Map<String, Object> keyMap = DSA_Encryption.initKey();

            // 获得密钥
            String publicKey = DSA_Encryption.getPublicKey(keyMap);
            String privateKey = DSA_Encryption.getPrivateKey(keyMap);

            System.out.println("公钥:\r" + publicKey);
            System.out.println("私钥:\r" + privateKey);

            // 产生签名
            String sign = DSA_Encryption.sign(data, privateKey);
            System.out.println("签名:\r" + sign);

            // 验证签名
            boolean status = DSA_Encryption.verify(data, publicKey, sign);
            System.out.println("状态:\r" + status);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}