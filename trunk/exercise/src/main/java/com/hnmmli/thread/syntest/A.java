package com.hnmmli.thread.syntest;

public class A extends Thread
{

    private BoundedBuffer1 test;

    public A(BoundedBuffer1 test)
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
