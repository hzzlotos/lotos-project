package javacore.security.online.encryption;

import java.util.Map;

public class DH_EncryptionTest
{

    public static void main(String[] args)
    {
        try
        {
            // 生成甲方密钥对儿
            Map<String, Object> aKeyMap = DH_Encryption.initKey();
            String aPublicKey = DH_Encryption.getPublicKey(aKeyMap);
            String aPrivateKey = DH_Encryption.getPrivateKey(aKeyMap);

            System.out.println("甲方公钥:\r" + aPublicKey);
            System.out.println("甲方私钥:\r" + aPrivateKey);

            // 由甲方公钥产生本地密钥对儿
            Map<String, Object> bKeyMap = DH_Encryption.initKey(aPublicKey);
            String bPublicKey = DH_Encryption.getPublicKey(bKeyMap);
            String bPrivateKey = DH_Encryption.getPrivateKey(bKeyMap);

            System.out.println("乙方公钥:\r" + bPublicKey);
            System.out.println("乙方私钥:\r" + bPrivateKey);

            String aInput = "abc ";
            System.out.println("原文: " + aInput);

            // 由甲方公钥，乙方私钥构建密文
            byte[] aCode = DH_Encryption.encrypt(aInput.getBytes(), aPublicKey, bPrivateKey);

            // 由乙方公钥，甲方私钥解密
            byte[] aDecode = DH_Encryption.decrypt(aCode, bPublicKey, aPrivateKey);
            String aOutput = (new String(aDecode));

            System.out.println("解密: " + aOutput);

            System.out.println(" ===============反过来加密解密================== ");
            String bInput = "def ";
            System.out.println("原文: " + bInput);

            // 由乙方公钥，甲方私钥构建密文
            byte[] bCode = DH_Encryption.encrypt(bInput.getBytes(), bPublicKey, aPrivateKey);

            // 由甲方公钥，乙方私钥解密
            byte[] bDecode = DH_Encryption.decrypt(bCode, aPublicKey, bPrivateKey);
            String bOutput = (new String(bDecode));

            System.out.println("解密: " + bOutput);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

}