package com.hnmmli.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest
{
    public static void main(String[] args)
    {
        LockTest ct = new LockTest();
        Thread t1 = new Complicating1(ct);
        Thread t2 = new Complicating1(ct);
        t1.start();
        t2.start();

    }

    private Lock lock = new ReentrantLock(); // 锁

    private int  index;

    public void test()
    {
        this.lock.lock();// 取得锁
        for (int i = 0; i < 10; i++)
        {
            this.index++;
            System.out.println("this is i=" + i + "; and index=" + this.index);
        }
        System.out.println("==================");
        this.lock.unlock();// 释放锁
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