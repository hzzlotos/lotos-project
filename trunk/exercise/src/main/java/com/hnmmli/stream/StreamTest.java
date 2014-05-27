package com.hnmmli.stream;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.PushbackInputStream;
import java.net.URLDecoder;

public class StreamTest
{
    public static void main(String[] args) throws Exception
    {
        // inputStreamTest();
        // outputStreamTest();
        // readTest();
        writeTest();
    }

    private static void inputStreamTest() throws Exception
    {
        String path = URLDecoder.decode(StreamTest.class.getClassLoader()
                .getResource("./com/hnmmli/stream/流学习test.txt").getPath(), "UTF-8");
        FileInputStream fis = new FileInputStream(new File(path));
        byte[] bs = new byte[50];
        System.out.println("========" + fis.read(bs));
        System.out.println(bs[0] + "===" + bs[1]);
        // 给input流添加缓存
        fis = new FileInputStream(new File(path)); // 因为上句已使用read
        BufferedInputStream buffis = new BufferedInputStream(fis);
        DataInputStream dis = new DataInputStream(buffis);
        System.out.println("========" + dis.readLong());
        PushbackInputStream pis = new PushbackInputStream(dis);
        System.out.println("========" + pis.read());
        pis.close();
        dis.close();
        fis.close();
    }

    private static void outputStreamTest() throws Exception
    {
        File f = new File("G:\\eclipse\\workspace\\exercise\\target\\classes\\com\\hnmmli\\stream\\流学习out_test.txt");
        FileOutputStream fos = new FileOutputStream(f);
        String test = "the outputsteam's test";
        byte[] bs = test.getBytes();
        fos.write(bs);
        fos.close();
    }

    private static void readTest() throws Exception
    {
        String path = URLDecoder.decode(StreamTest.class.getClassLoader()
                .getResource("./com/hnmmli/stream/流学习test.txt").getPath(), "UTF-8");
        BufferedReader br = new BufferedReader(new FileReader(path));
        String line;
        while ((line = br.readLine()) != null)
        {
            System.out.println("========" + line);
        }
        br.close();
    }

    private static void writeTest() throws Exception
    {
        File f = new File("G:\\eclipse\\workspace\\exercise\\target\\classes\\com\\hnmmli\\stream\\流学习write_test.txt");
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(f)));
        String test = "the outputsteam's test";
        pw.println(test);
        pw.println(test);
        pw.close();
    }
}