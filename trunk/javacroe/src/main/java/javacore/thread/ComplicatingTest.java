package javacore.thread;

//并发产生的问题
public class ComplicatingTest
{
    private int index;

    public void test()
    {
        for (int i = 0; i < 10; i++)
        {
            this.index++;
            System.out.println("this is i=" + i + "; and index=" + this.index);
        }
    }

    public static void main(String[] args)
    {
        ComplicatingTest ct = new ComplicatingTest();
        Thread t1 = new Complicating(ct);
        Thread t2 = new Complicating(ct);
        t1.start();
        t2.start();
    }
}

class Complicating extends Thread
{
    private ComplicatingTest c;

    public Complicating(ComplicatingTest c)
    {
        this.c = c;
    }

    @Override
    public void run()
    {
        this.c.test();
    }
}