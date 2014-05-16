package com.hnmmli.thread.syntest;

public class BoundedBuffer1
{

    public void put(Object x) throws InterruptedException
    {
        System.out.println("put=== start");// 自己加的
        synchronized (this)
        {
            while (Buffer.count == Buffer.items.length)
            {
                System.out.println("put===notFull===await");// 自己加的
                this.wait();
            }
            // 赋值
            Buffer.items[Buffer.putptr] = x;
            // 如果写索引写到队列的最后一个位置了，那么置为0
            if (++Buffer.putptr == Buffer.items.length)
            {
                Buffer.putptr = 0;
            }
            // 个数++
            ++Buffer.count;
            // 唤醒读线程
        }
        Thread.sleep(1000);// 自己加的
    }
}