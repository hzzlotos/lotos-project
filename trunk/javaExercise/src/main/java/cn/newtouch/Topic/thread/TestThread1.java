package cn.newtouch.Topic.thread;

public class TestThread1
{
    public static void main(String args[])
    {
        Runner1 r = new Runner1();
        // r.start();// runnable 无此方法
        // r.run(); //方法调用 没有启动线程 只是run方法的调用
        Thread t = new Thread(r);
        t.start();

        for (int i = 0; i < 100; i++)
        {
            System.out.println("Main Thread:------" + i);
        }
    }
}

class Runner1 implements Runnable
// class Runner1 extends Thread
{
    public void run()
    {
        for (int i = 0; i < 100; i++)
        {
            System.out.println("Runner1 :" + i);
        }
    }
}
