package javacore.thread;

import java.util.concurrent.CountDownLatch;

public class Sync_CountDownLatchTest
{

    public static void main(String[] args)
    {
        //
        CountDownLatch begin = new CountDownLatch(1);
        CountDownLatch end = new CountDownLatch(7);
        for (int i = 0; i < 7; i++)
        {
            new Thread(new AWorker(i, begin, end)).start();
        }
        try
        {
            Thread.sleep((long) (Math.random() * 5000));
        }
        catch (InterruptedException e1)
        {
            e1.printStackTrace();
        }
        System.out.println("judge say : run !");
        // 减少锁存器的计数 因为设置为1,所以该处将begin线程全部释放.
        begin.countDown();

        try
        {
            end.await();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        finally
        {
            System.out.println("judge say : all arrived !");
        }
    }
}

class AWorker implements Runnable
{
    CountDownLatch begin;

    CountDownLatch end;

    int            id;

    public AWorker(int id, CountDownLatch begin, CountDownLatch end)
    {
        this.id = id;
        this.begin = begin;
        this.end = end;
    }

    @Override
    public void run()
    {
        try
        {
            System.out.println(this.id + " ready !");
            this.begin.await();
            Thread.sleep((long) (Math.random() * 10000));
        }
        catch (Throwable e)
        {
            e.printStackTrace();
        }
        finally
        {
            System.out.println(this.id + " arrived !");
            this.end.countDown();
        }
    }
}