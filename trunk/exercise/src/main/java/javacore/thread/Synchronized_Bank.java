package javacore.thread;

import java.util.Random;

public class Synchronized_Bank
{
    private int[] account;

    public Synchronized_Bank(int[] account)
    {
        this.account = account;
    }

    public synchronized void syso1()
    {
        System.out.println("======syso=======");
        for (int i : this.account)
        {
            System.out.println(i);
        }
        System.out.println("======syso=======");
    }

    public synchronized void transfer(int from, int to, int amount) throws Exception
    {
        // System.out.println("==========start============");
        while (this.account[from] < amount)
        {
            System.out.println("========================" + Thread.currentThread().getName() + "======start");
            System.out.println(from);
            System.out.println(to);
            System.out.println(amount);
            System.out.println("wait");
            this.wait();
        }
        this.account[from] -= amount;
        this.account[to] += amount;
        this.notifyAll();
        this.syso1();
        // System.out.println("==========end============");
    }

    public static void main(String[] args)
    {
        int[] account = new int[] { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 };
        Synchronized_Bank sb = new Synchronized_Bank(account);
        for (int i = 0; i < 100; i++)
        {
            SB temp = new SB(sb, new Random().nextInt(10), new Random().nextInt(10), new Random().nextInt(15));
            temp.start();
        }
    }
}

class SB extends Thread
{
    private Synchronized_Bank sb;

    private int               from;

    private int               to;

    private int               amount;

    public SB(Synchronized_Bank sb, int from, int to, int amount)
    {
        this.sb = sb;
        this.from = from;
        this.to = to;
        this.amount = amount;
    }

    @Override
    public void run()
    {
        try
        {
            this.sb.transfer(this.from, this.to, this.amount);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}