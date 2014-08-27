package com.hnmmli.stream.nio;

import java.io.FileInputStream;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public class FileChannelTest
{
    public static void main(String[] args)
    {
        try
        {
            FileInputStream fis = new FileInputStream("employee.dat");
            FileChannel fc = fis.getChannel();
            FileLock lock = fc.lock();
            // FileLock lock = fc.tryLock();
            // fc.map(mode, position, size);
            System.out.println(lock.isValid());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
