package cn.newtouch.Topic.thread;

import java.util.Date;

public class TestInterrupt
{
    public static void main(String[] args)
    {
        MyThread thread = new MyThread();
        thread.start();
        try
        {
            Thread.sleep(10000);
        }
        catch (InterruptedException e)
        {
            System.out.println("wo chu cuo");
        }
        thread.interrupt();
    }
}

class MyThread extends Thread
{
    boolean flag = true;

    @Override
    public void run()
    {
        while (this.flag)
        {
            System.out.println("===" + new Date() + "===");
            try
            {
                super.sleep(1000);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
                return;
            }
        }
    }
}