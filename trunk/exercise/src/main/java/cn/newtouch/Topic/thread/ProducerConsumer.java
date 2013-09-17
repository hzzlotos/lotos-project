package cn.newtouch.Topic.thread;

public class ProducerConsumer
{
    public static void main(String[] args)
    {
        SyncStack1 ss = new SyncStack1();
        // Producer1 p1 = new Producer1(ss, "p1");
        // Producer1 p2 = new Producer1(ss, "p2");
        Producer1 p3 = new Producer1(ss, "p3");
        Consumer1 c = new Consumer1(ss, "c1");
        // new Thread(p1).start();
        // new Thread(p2).start();
        new Thread(p3).start();
        new Thread(c).start();
    }
}

class WoTou
{
    int id;

    WoTou(int id)
    {
        this.id = id;
    }

    @Override
    public String toString()
    {
        return "WoTou : " + id;
    }
}

class SyncStack1
{
    int     index = 0;

    WoTou[] arrWT = new WoTou[6];

    public synchronized void push(WoTou wt)
    {
        while (index == arrWT.length)
        {
            try
            {
                this.wait();
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
        this.notifyAll();
        arrWT[index] = wt;
        index++;
    }

    public synchronized WoTou pop()
    {
        while (index == 0)
        {
            try
            {
                this.wait();
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
        this.notifyAll();
        index--;
        return arrWT[index];
    }
}

class Producer1 implements Runnable
{
    String     name;

    SyncStack1 ss = null;

    Producer1(SyncStack1 ss, String name)
    {
        this.ss = ss;
        this.name = name;
    }

    public void run()
    {
        for (int i = 0; i < 20; i++)
        {
            System.out.println(name + "==ppp==" + i + "----" + ss.index);
            WoTou wt = new WoTou(i);
            ss.push(wt);
            System.out.println(name + " 生产了 : " + wt);
            try
            {
                Thread.sleep((int) (Math.random() * 200));
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
}

class Consumer1 implements Runnable
{
    SyncStack1 ss = null;

    String     name;

    Consumer1(SyncStack1 ss, String name)
    {
        this.ss = ss;
        this.name = name;
    }

    public void run()
    {
        for (int i = 0; i < 60; i++)
        {
            System.out.println(name + "==ccc==" + i + "----" + ss.index);
            WoTou wt = ss.pop();
            System.out.println(name + " 消费了: " + wt);
            try
            {
                Thread.sleep((int) (Math.random() * 1000));
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
}