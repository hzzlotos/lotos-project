package com.hnmmli.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest
{

    public static void main(String[] args)
    {
        final int count = 5;
        final CyclicBarrier cyclicBarrier = new CyclicBarrier(count, new Runnable() {
            @Override
            public void run()
            {
                System.out.println("drink beer!");
            }
        });

        for (int i = 0; i < count; i++)
        {
            new Thread(new Worker(i, cyclicBarrier)).start();
        }
    }

}

class Worker implements Runnable
{
    final int           id;

    final CyclicBarrier barrier;

    public Worker(final int id, final CyclicBarrier barrier)
    {
        this.id = id;
        this.barrier = barrier;
    }

    @Override
    public void run()
    {
        try
        {
            System.out.println(this.id + "starts to run !");
            Thread.sleep((long) (Math.random() * 10000));
            System.out.println(this.id + "arrived !");
            this.barrier.await();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        catch (BrokenBarrierException e)
        {
            e.printStackTrace();
        }
    }
}
