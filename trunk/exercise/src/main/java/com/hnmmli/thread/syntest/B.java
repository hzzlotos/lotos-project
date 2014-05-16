package com.hnmmli.thread.syntest;

public class B extends Thread
{

    private BoundedBuffer2 test;

    public B(BoundedBuffer2 test)
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
