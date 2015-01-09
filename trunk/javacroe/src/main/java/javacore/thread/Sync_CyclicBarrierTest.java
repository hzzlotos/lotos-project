package javacore.thread;

import java.util.concurrent.CyclicBarrier;

public class Sync_CyclicBarrierTest
{

    public static void main(String[] args)
    {
        // 在规定的线程个数完成之前, 需执行的线程不会被执行.
        final CyclicBarrier cyclicBarrier = new CyclicBarrier(5, new Runnable() {
            @Override
            public void run()
            {
                System.out.println("drink beer!");
            }
        });
        // 由于count设置为5,即完成5个则可以通过栅栏了.
        for (int i = 0; i < 7; i++)
        {
            new Thread(new Worker(i, cyclicBarrier)).start();
        }
    }

}

class Worker implements Runnable
{
    final int           id;

    final CyclicBarrier cyclicBarrier;

    public Worker(final int id, final CyclicBarrier cyclicBarrier)
    {
        this.id = id;
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run()
    {
        try
        {
            System.out.println(this.id + "starts to run !");
            Thread.sleep((long) (Math.random() * 10000));
            System.out.println(this.id + "arrived !");
            // 将该线程挂起在栅栏内,直至栅栏挂起的线程个数等于预设定值时,执行后续所设置的线程
            this.cyclicBarrier.await();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
