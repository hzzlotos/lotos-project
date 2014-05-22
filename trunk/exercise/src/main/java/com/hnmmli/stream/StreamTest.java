package com.hnmmli.stream;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.PushbackInputStream;
import java.net.URLDecoder;

public class StreamTest
{
    public static void main(String[] args) throws Exception
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
}