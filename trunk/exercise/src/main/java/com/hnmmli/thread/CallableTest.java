package com.hnmmli.thread;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

class TaskWithResult implements Callable<String>
{
    private int id;

    public TaskWithResult(int id)
    {
        this.id = id;
    }

    @Override
    public String call() throws Exception
    {
        return "" + this.id;
    }
}

public class CallableTest
{
    public static void main(String[] args) throws Exception
    {
        // testNo1();
        testNo2();
    }

    private static void testNo1() throws Exception
    {
        Callable<String> myCallable = new TaskWithResult(111);
        FutureTask<String> task = new FutureTask<String>(myCallable);
        Thread t = new Thread(task);
        t.start();
        System.out.println("=========================    " + task.get());
    }

    private static void testNo2() throws Exception
    {

        ExecutorService exec = Executors.newCachedThreadPool();
        ArrayList<Future<String>> results = new ArrayList<Future<String>>(); // Future 相当于是用来存放Executor执行的结果的一种容器
        for (int i = 0; i < 10; i++)
        {
            results.add(exec.submit(new TaskWithResult(i)));
        }
        for (Future<String> fs : results)
        {
            if (fs.isDone())
            {
                System.out.println("结果是=========================" + fs.get());
            }
            else
            {
                boolean a = false;
                while (!a)
                {
                    System.out.println("失败了!====");
                    if (fs.isDone())
                    {
                        System.out.println(fs.get());
                        a = true;
                    }
                }
            }
        }
        exec.shutdown();
    }
}