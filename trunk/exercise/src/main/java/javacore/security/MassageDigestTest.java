package javacore.security;

import java.security.MessageDigest;

public class MassageDigestTest
{
    public static void main(String[] args)
    {
        byte[] test = "test".getBytes();
        MessageDigest md;
        try
        {
            md = MessageDigest.getInstance("SHA-1");
            md.update(test);
            byte[] bs1 = md.digest();
            System.out.println(bs1.toString());// 只是打印了byte数组的hashcode
            for (byte b : bs1)
            {
                System.out.print(b + " ");
            }
            System.out.println("");
            System.out.println("----------------------------------------------");
            md.reset();// 若需要再次运算之前需要reset一次
            md = MessageDigest.getInstance("MD5");
            md.update(test);
            byte[] bs2 = md.digest();
            System.out.println(bs2.toString());// 只是打印了byte数组的hashcode
            for (byte b : bs2)
            {
                System.out.print(b + " ");
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}