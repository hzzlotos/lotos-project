package javacore.security;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.SecureRandom;
import java.util.Random;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

public class DesUtil
{
    private static Random randGen           = null;

    private static char[] numbersAndLetters = null;

    /**
     * 加密
     * 
     * @param datasource
     * @param password
     * @return
     */
    public static String desCrypt(String datasource, String password)
    {
        try
        {
            SecureRandom random = new SecureRandom();
            DESKeySpec desKey = new DESKeySpec(password.getBytes());

            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey securekey = keyFactory.generateSecret(desKey);
            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(Cipher.ENCRYPT_MODE, securekey, random);
            return parseByte2HexStr(cipher.doFinal(datasource.getBytes()));
        }
        catch (Throwable e)
        {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 加密文件
     * 
     * @param file
     * @param dest
     *            加密后文件名
     * @param password
     * @throws Exception
     */
    public static void desCrypt(String file, String dest, String password) throws Exception
    {
        Cipher cipher = Cipher.getInstance("DES");
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        DESKeySpec desKey = new DESKeySpec(password.getBytes());
        SecretKey securekey = keyFactory.generateSecret(desKey);
        cipher.init(Cipher.ENCRYPT_MODE, securekey);
        InputStream is = new FileInputStream(file);
        OutputStream out = new FileOutputStream(dest);
        CipherInputStream cis = new CipherInputStream(is, cipher);
        byte[] buffer = new byte[1024];
        int r;
        while ((r = cis.read(buffer)) > 0)
        {
            out.write(buffer, 0, r);
        }
        cis.close();
        is.close();
        out.close();
    }

    /**
     * 解密加密文件
     * 
     * @param file
     * @param dest
     * @param password
     * @throws Exception
     */
    public static void decrypt(String file, String dest, String password) throws Exception
    {
        Cipher cipher = Cipher.getInstance("DES");
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        DESKeySpec desKey = new DESKeySpec(password.getBytes());
        SecretKey securekey = keyFactory.generateSecret(desKey);
        cipher.init(Cipher.DECRYPT_MODE, securekey);
        InputStream is = new FileInputStream(file);
        OutputStream out = new FileOutputStream(dest);
        CipherOutputStream cos = new CipherOutputStream(out, cipher);
        byte[] buffer = new byte[1024];
        int r;
        while ((r = is.read(buffer)) >= 0)
        {
            cos.write(buffer, 0, r);
        }
        cos.close();
        out.close();
        is.close();
    }

    /**
     * 解密
     * 
     * @param src
     * @param password
     * @return
     * @throws Exception
     */
    public static String decrypt(String src, String password)
    {
        try
        {
            SecureRandom random = new SecureRandom();
            DESKeySpec desKey = new DESKeySpec(password.getBytes());
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey securekey = keyFactory.generateSecret(desKey);
            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(Cipher.DECRYPT_MODE, securekey, random);
            return new String(cipher.doFinal(parseHexStr2Byte(src)));
        }
        catch (Throwable e)
        {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 将二进制转换成16进制
     * 
     * @param buf
     * @return
     */
    public static String parseByte2HexStr(byte buf[])
    {
        StringBuffer sb = new StringBuffer();
        for (byte element : buf)
        {
            String hex = Integer.toHexString(element & 0xFF);
            if (hex.length() == 1)
            {
                hex = '0' + hex;
            }
            sb.append(hex.toUpperCase());
        }
        return sb.toString();
    }

    /**
     * 将16进制转换为二进制
     * 
     * @param hexStr
     * @return
     */
    public static byte[] parseHexStr2Byte(String hexStr)
    {
        if (hexStr.length() < 1)
        {
            return null;
        }
        byte[] result = new byte[hexStr.length() / 2];
        for (int i = 0; i < hexStr.length() / 2; i++)
        {
            int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
            int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2), 16);
            result[i] = (byte) (high * 16 + low);
        }
        return result;
    }

    /**
     * 生成随机字符串
     * 
     * @param length
     * @return
     */
    public static String randomString(int length)
    {
        if (length < 1)
        {
            return null;
        }
        if (randGen == null)
        {
            randGen = new Random();
            numbersAndLetters = ("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ").toCharArray();
        }
        char[] randBuffer = new char[length];
        for (int i = 0; i < randBuffer.length; i++)
        {
            randBuffer[i] = numbersAndLetters[randGen.nextInt(62)];
        }
        return new String(randBuffer);
    }

    /**
     * des加密密码，必须是8的倍数
     * 
     * @return
     */
    public static String getPassword()
    {
        return randomString(8);
    }

    /**
     * 按照一定规则产生授权码
     * 
     * @param kaociCode
     * @param changciCode
     * @param kaochangCode
     * @param itemCode
     * @param key
     * @return
     */
    public static String generateAuthCode(String kaociCode, String changciCode, String kaochangCode, String itemCode,
            String key)
    {
        int kaociYs = Integer.parseInt(kaociCode) % 10;
        int changciYs = Integer.parseInt(changciCode) % 10;
        int kaochangYs = Integer.parseInt(kaochangCode) % 10;
        int itemYs = Integer.parseInt(itemCode) % 10;
        // int[] newKeys = new int[key.length()];
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < key.length(); i++)
        {
            sb.append(String.valueOf((key.charAt(i)) % 10));
            System.out.println(" <br> " + key.substring(i, i + 1) + "--> asc== " + (int) key.charAt(i));
            System.out.println(" <br> " + (int) key.charAt(i) + "--> asc== " + (key.charAt(i)));
        }

        long newvalue = Long.parseLong(sb.toString()) + kaociYs + changciYs + kaochangYs + itemYs;

        return newvalue + "";
    }

    /**
     * 产生脱机登录授权码
     * 和日期相关，每日的是一样的
     * 
     * @param kaochangCode
     * @param itemCode
     * @return
     */
    public static String generateOfflineAuthCode(String kaochangCode, String itemCode)
    {
        int kaochangYs = Integer.parseInt(kaochangCode) % 10;
        int itemYs = Integer.parseInt(itemCode) % 10;
        // int time = Integer.parseInt(DateUtils.getDateFromDateTime(new Date(), "yyMMdd"));
        // int time2 = Integer.parseInt(DateUtils.getDateFromDateTime(new Date(), "ddMMyy"));
        long newvalue = kaochangYs + itemYs;// + time + time2;
        return newvalue + "";
    }

    public static void main(String[] args) throws Exception
    {
        // generateOfflineAuthCode("0002","00040009","0004007008","2","3393e222");
        // System.out.println(generateOfflineAuthCode("0002",CommonConstant.RIGHT_TUOJILOGIN));
        String password1 = "drclpswd";
        String input1 = "201112";
        String input2 = "abdf23";
        String input3 = "abdf232";
        String input4 = "abdf";

        String key1 = "658114E741945E263DBD20E90A35BF6D";
        String key2 = "478156FFC6ECCDB9";

        System.out.println(desCrypt(input1, password1));
        System.out.println(desCrypt(input2, password1));
        System.out.println(desCrypt(input3, password1));
        System.out.println(desCrypt(input4, password1));
        System.out.println(decrypt(key1, password1));
        System.out.println(decrypt(key2, password1));

        // 加密文件
        desCrypt("e:/exam.json", "e:/exam1", "drclpswd");
        // 解密文件
        decrypt("e:/exam1", "e:/exam1.json", "drclpswd");
        decrypt("I:/upload/centre/key_dad21313", "I:/upload/centre/key_dad213132", "1fXivmEz");

    }
}
