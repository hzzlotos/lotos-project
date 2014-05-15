package com.hnmmli.thread;

import java.util.Date;

public class ThreadTest
{
    public static void main(String[] args)
    {
        // runnable();
        // joinTest();
        joinTest2();
    }

    private static void runnable()
    {
        Runnable r = new MyRunnable();
        Thread t = new Thread(r);
        t.start();
        System.out.println("aaaa=========" + t.isInterrupted());
        try
        {
            t.sleep(100L);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        t.interrupt();
        System.out.println("aaaa=========" + t.isInterrupted());
    }

    private static void joinTest()
    {
        Thread thread1 = new A();
        thread1.start();
        System.out.println("===========test");
        Thread thread2 = new A();
        thread2.start();
        try
        {
            thread2.join();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        System.out.println("===========test");
    }

    private static void joinTest2()
    {
        Thread thread1 = new B();
        Thread thread2 = new C();
        thread1.start();
        thread2.start();
        System.out.println("===========test");
        try
        {
            thread2.join();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        System.out.println("===========test");
    }
}

class MyRunnable implements Runnable
{

    @Override
    public void run()
    {
        while (!Thread.currentThread().isInterrupted())
        {
            System.out.println("=========" + new Date().toString());
        }
    }
}

class A extends Thread
{
    @Override
    public void run()
    {
        System.out.println("==============a");
    }
}

class B extends Thread
{
    @Override
    public void run()
    {
        for (int i = 0; i < 10; i++)
        {
            System.out.println("B : " + i);
            if (i == 9)
            {
                break;
            }
            try
            {
                Thread.sleep(1000);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
}

class C extends Thread
{
    @Override
    public void run()
    {
        for (int i = 0; i < 5; i++)
        {
            System.out.println("C : " + i);
            if (i == 4)
            {
                break;
            }
            try
            {
                Thread.sleep(1000);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
}