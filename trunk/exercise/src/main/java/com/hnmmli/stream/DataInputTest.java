package com.hnmmli.stream;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class DataInputTest
{
    public static void main(String[] args)
    {
        try
        {
            DataInputStream dis = new DataInputStream(new FileInputStream("F:\\物资编码_程总.xls"));
            byte[] bytes = new byte[dis.available()];
            dis.read(bytes);
            dis.close();
            DataOutputStream dos = new DataOutputStream(new FileOutputStream("E:\\物资编码_程总.xls"));
            dos.write(bytes);
            dos.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}