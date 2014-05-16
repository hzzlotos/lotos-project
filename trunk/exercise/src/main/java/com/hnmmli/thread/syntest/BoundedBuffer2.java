package com.hnmmli.thread.syntest;

public class BoundedBuffer2
{
    public Object take() throws InterruptedException
    {
        System.out.println("take=== start");// 自己加的
        Object x = null;
        synchronized (this)
        {
            while (Buffer.count == 0)
            {
                System.out.println("take===notEmpty===await");// 自己加的
                // 阻塞读线程
                this.wait();
            }
            // 取值
            x = Buffer.items[Buffer.takeptr];
            System.out.println("-----thegetX=" + x);// 自己加的
            // 如果读索引读到队列的最后一个位置了，那么置为0
            if (++Buffer.takeptr == Buffer.items.length)
            {
                Buffer.takeptr = 0;
            }
            // 个数--
            --Buffer.count;
            // 唤醒写线程
        }
        Thread.sleep(2000);// 自己加的
        return x;
    }
}