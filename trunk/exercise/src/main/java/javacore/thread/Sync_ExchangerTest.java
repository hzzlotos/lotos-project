package javacore.thread;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Exchanger;

/**
 * Exchanger让两个线程可以互换信息。
 * 例子中服务生线程往空的杯子里倒水，顾客线程从装满水的杯子里喝水，
 * 然后通过Exchanger双方互换杯子，服务生接着往空杯子里倒水，顾客接着喝水，
 * 然后交换，如此周而复始。
 */
public class Sync_ExchangerTest
{
    private static void testExchanger()
    {
        // 初始化一个Exchanger，并规定可交换的信息类型是杯子
        final Exchanger<Cup> exchanger = new Exchanger<Cup>();
        // 初始化一个空的杯子和装满水的杯子
        final Cup initialEmptyCup = new Cup(false, 1);
        final Cup initialFullCup = new Cup(true, 2);
        new Thread(new Waiter(initialEmptyCup, exchanger)).start();
        new Thread(new Customer(initialFullCup, exchanger)).start();
    }

    public static void main(String[] args)
    {
        testExchanger();
    }
}

// 服务生线程
class Waiter implements Runnable
{
    private Cup            currentCup;

    private Exchanger<Cup> exchanger;

    public Waiter(Cup currentCup, Exchanger<Cup> exchanger)
    {
        this.currentCup = currentCup;
        this.exchanger = exchanger;
    }

    @Override
    public void run()
    {

        try
        {
            int i = 0;
            while (i < 2)
            {
                System.out.println("服务生开始往杯子中添水：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
                // 往空的杯子里加水
                this.currentCup.addWater();
                System.out.println("服务生添水完毕：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
                System.out.println("这是" + this.currentCup.getIndex() + "号杯子");
                this.currentCup = this.exchanger.exchange(this.currentCup);
                System.out.println("服务生与顾客交换杯子完毕：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
                i++;
            }
        }
        catch (InterruptedException ex)
        {
        }
    }
}

// 顾客线程
class Customer implements Runnable
{
    private Cup            currentCup;

    private Exchanger<Cup> exchanger;

    public Customer(Cup currentCup, Exchanger<Cup> exchanger)
    {
        this.currentCup = currentCup;
        this.exchanger = exchanger;
    }

    @Override
    public void run()
    {
        try
        {
            int i = 0;
            while (i < 2)
            {
                System.out.println("顾客开始喝水：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
                // 把杯子里的水喝掉
                this.currentCup.drinkWater();
                System.out.println("顾客喝水完毕：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
                System.out.println("这是" + this.currentCup.getIndex() + "号杯子");
                this.currentCup = this.exchanger.exchange(this.currentCup);
                System.out.println("顾客与服务生交换杯子完毕：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
                i++;
            }
        }
        catch (InterruptedException ex)
        {
        }
    }
}

// 描述一个装水的杯子
class Cup
{
    // 标识杯子是否有水
    private boolean full = false;

    private int     index;

    public int getIndex()
    {
        return this.index;
    }

    public Cup(boolean full, int index)
    {
        this.full = full;
        this.index = index;
    }

    // 添水，假设需要5s
    public void addWater()
    {
        if (!this.full)
        {
            try
            {
                Thread.sleep(5000);
            }
            catch (InterruptedException e)
            {
            }
            this.full = true;
        }
    }

    // 喝水，假设需要10s
    public void drinkWater()
    {
        if (this.full)
        {
            try
            {
                Thread.sleep(10000);
            }
            catch (InterruptedException e)
            {
            }
            this.full = false;
        }
    }
}