package com.hnmmli.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest
{
    public static void main(String[] args)
    {
        testNo();
    }

    private static void testNo()
    {
        LockTest ct = new LockTest();
        Thread t1 = new Complicating1(ct);
        Thread t2 = new Complicating2(ct);
        Thread t3 = new Complicating1(ct);
        t1.start();
        t2.start();
        t3.start();
    }

    private Lock lock = new ReentrantLock(); // 锁

    private int  index;

    public void test()
    {
        boolean flag = false;
        while (!flag)
        {
            // 取得锁,如果没有抢占成功,该锁被阻塞了.
            System.out.println("我要锁!");
            if (this.lock.tryLock())
            {
                System.out.println("终于进来了");
                try
                {
                    for (int i = 0; i < 10; i++)
                    {
                        this.index++;
                        System.out.println("this is 不是随便搞搞的 i=" + i + "; and index=" + this.index);
                    }
                    System.out.println("==================");
                }
                finally
                {
                    flag = true;
                    this.lock.unlock();// 释放锁
                }
            }
            else
            {
                System.out.println("==============获取锁失败了");
            }
        }
    }

    public void test1()
    {
        // 取得锁
        this.lock.lock();
        try
        {
            for (int i = 0; i < 10; i++)
            {
                this.index++;
                System.out.println("this is 随便搞搞的   i=" + i + "; and index=" + this.index);
            }
            System.out.println("==================");
        }
        finally
        {
            // 释放锁
            this.lock.unlock();
        }
    }
}

class Complicating1 extends Thread
{
    private LockTest c;

    public Complicating1(LockTest c)
    {
        this.c = c;
    }

    @Override
    public void run()
    {
        this.c.test();
    }
}

class Complicating2 extends Thread
{
    private LockTest c;

    public Complicating2(LockTest c)
    {
        this.c = c;
    }

    @Override
    public void run()
    {
        this.c.test1();
    }
}