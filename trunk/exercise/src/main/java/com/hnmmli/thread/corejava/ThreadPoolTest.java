package com.hnmmli.thread.corejava;

import java.io.File;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadPoolTest
{
    public static void main(String[] args) throws Exception
    {
        String directory = "E://test//queue";
        String keyword1 = "a";
        String keyword2 = "b";
        String keyword3 = "c";

        ExecutorService pool = Executors.newCachedThreadPool();

        MatchCounter counter1 = new MatchCounter(new File(directory), keyword1, pool);
        MatchCounter counter2 = new MatchCounter(new File(directory), keyword2, pool);
        MatchCounter counter3 = new MatchCounter(new File(directory), keyword3, pool);
        Future<Integer> result1 = pool.submit(counter1);
        Future<Integer> result2 = pool.submit(counter2);
        Future<Integer> result3 = pool.submit(counter3);
        try
        {
            System.out.println(result1.get() + " matching files.");
            System.out.println(result2.get() + " matching files.");
            System.out.println(result3.get() + " matching files.");
        }
        catch (ExecutionException e)
        {
            e.printStackTrace();
        }
        catch (InterruptedException e)
        {
        }
        pool.shutdown();

        int largestPoolSize = ((ThreadPoolExecutor) pool).getLargestPoolSize();
        System.out.println("largest pool size=" + largestPoolSize);
    }
}

// class MatchCounter implements Callable<Integer>
// {}
