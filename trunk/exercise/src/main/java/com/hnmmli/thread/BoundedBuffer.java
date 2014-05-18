package com.hnmmli.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BoundedBuffer
{
    final Lock      lock     = new ReentrantLock();     // 锁对象

    final Condition notFull  = this.lock.newCondition(); // 写线程条件

    final Condition notEmpty = this.lock.newCondition(); // 读线程条件

    final Object[]  items    = new Object[5];           // new Object[100]; // 缓存队列

    int             putptr/* 写索引 */, takeptr/* 读索引 */, count/* 队列中存在的数据个数 */;

    public void put(Object x) throws InterruptedException
    {
        this.lock.lock();
        System.out.println("put=== start");// 自己加的
        try
        {
            while (this.count == this.items.length)
            {
                // 阻塞写线程
                this.notFull.await();
                System.out.println("put===notFull===await");// 自己加的
            }
            // 赋值
            this.items[this.putptr] = x;
            // 如果写索引写到队列的最后一个位置了，那么置为0
            if (++this.putptr == this.items.length)
            {
                this.putptr = 0;
            }
            // 个数++
            ++this.count;
            // 唤醒读线程
            this.notEmpty.signal();
        }
        finally
        {
            System.out.println("put===count==" + this.count);// 自己加的
            this.lock.unlock();
        }
        Thread.sleep(1000);// 自己加的
    }

    public Object take() throws InterruptedException
    {
        this.lock.lock();
        System.out.println("take=== start");// 自己加的
        try
        {
            while (this.count == 0)
            {
                // 阻塞读线程
                this.notEmpty.await();
                System.out.println("take===notEmpty===await");// 自己加的
            }
            // 取值
            Object x = this.items[this.takeptr];
            System.out.println("-----thegetX=" + x);// 自己加的
            // 如果读索引读到队列的最后一个位置了，那么置为0
            if (++this.takeptr == this.items.length)
            {
                this.takeptr = 0;
            }
            // 个数--
            --this.count;
            // 唤醒写线程
            this.notFull.signal();
            return x;
        }
        finally
        {
            System.out.println("get===count===" + this.count);// 自己加的
            this.lock.unlock();
            Thread.sleep(2000);// 自己加的
        }
    }

    public static void main(String[] args)
    {
        BoundedBuffer test = new BoundedBuffer();
        Thread aa = new AA(test);
        Thread aa2 = new AA(test);
        Thread aa3 = new AA(test);
        Thread bb = new BB(test);
        // Thread bb2 = new BB(test);
        aa.start();
        aa2.start();
        aa3.start();
        bb.start();
        // bb2.start();
    }
}

class AA extends Thread
{

    private BoundedBuffer test;

    public AA(BoundedBuffer test)
    {
        this.test = test;
    }

    @Override
    public void run()
    {
        try
        {
            int i = 0;
            while (true)
            {
                i++;
                this.test.put(i);
            }
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}

class BB extends Thread
{

    private BoundedBuffer test;

    public BB(BoundedBuffer test)
    {
        this.test = test;
    }

    @Override
    public void run()
    {
        try
        {
            while (true)
            {
                this.test.take();
            }
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}