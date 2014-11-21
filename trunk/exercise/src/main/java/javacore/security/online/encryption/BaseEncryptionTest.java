package javacore.security.online.encryption;

public class BaseEncryptionTest
{
    public static void main(String[] args)
    {
        try
        {
            String inputStr = "简单加密"; // 566A5Y2V5Yqg5a+G
            // inputStr = "Tom"; // VG9t
            // inputStr = "Lucy "; // THVjeSA=
            byte[] inputData = inputStr.getBytes();
            String code = BaseEncryption.encryptByApacheBASE64(inputData);
            byte[] output = BaseEncryption.decryptByApacheBASE64(code);
            String outputStr = new String(output);

            byte[] md51 = BaseEncryption.encryptMD5(inputData);
            BaseEncryption.encryptMD5(inputData);

            byte[] sha1 = BaseEncryption.encryptSHA(inputData);
            byte[] sha2 = BaseEncryption.encryptSHA(inputData);

            String key = BaseEncryption.initMacKey();
            byte[] mac1 = BaseEncryption.encryptHMAC(inputData, key);
            byte[] mac2 = BaseEncryption.encryptHMAC(inputData, key);

            System.out.println("=============================================");
            System.out.println("验证BASE64加密解密一致性");
            System.out.println("inputStr：" + inputStr);
            System.out.println("code：" + code);
            System.out.println("outputStr：" + outputStr);
            System.out.println("-----------------------------------------");

            System.out.println("验证MD5对于同一内容加密是否一致");
            showBytes(md51);
            showBytes(md51);
            System.out.println("-----------------------------------------");

            System.out.println("验证SHA对于同一内容加密是否一致");
            showBytes(sha1);
            showBytes(sha2);
            System.out.println("-----------------------------------------");

            System.out.println("验证HMAC对于同一内容，同一密钥加密是否一致");

            System.out.println("Mac密钥：" + key);
            showBytes(mac1);
            showBytes(mac2);
            System.out.println("=============================================");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private static void showBytes(byte[] bs)
    {
        for (Byte b : bs)
        {
            System.out.print(b + " ");
        }
        System.out.println();
    }
}
