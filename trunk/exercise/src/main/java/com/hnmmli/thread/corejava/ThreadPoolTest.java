package com.hnmmli.thread.corejava;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.Callable;
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

class MatchCounter implements Callable<Integer>
{
    private int             count;

    private File            directory;

    private String          keyword;

    private ExecutorService pool;

    /**
     * Constructs a MatchCounter.
     * 
     * @param directory the directory in which to start the search
     * @param keyword the keyword to look for
     * @param pool the thread pool for submitting subtasks
     */
    public MatchCounter(File directory, String keyword, ExecutorService pool)
    {
        this.directory = directory;
        this.keyword = keyword;
        this.pool = pool;
    }

    @Override
    public Integer call()
    {
        this.count = 0;
        try
        {
            File[] files = this.directory.listFiles();
            ArrayList<Future<Integer>> results = new ArrayList<Future<Integer>>();

            for (File file : files)
            {
                if (file.isDirectory())
                {
                    MatchCounter counter = new MatchCounter(file, this.keyword, this.pool);
                    Future<Integer> result = this.pool.submit(counter);
                    results.add(result);
                }
                else
                {
                    if (this.search(file))
                    {
                        this.count++;
                    }
                }
            }

            for (Future<Integer> result : results)
            {
                try
                {
                    this.count += result.get();
                }
                catch (ExecutionException e)
                {
                    e.printStackTrace();
                }
            }
        }
        catch (InterruptedException e)
        {
        }
        return this.count;
    }

    public boolean search(File file)
    {
        try
        {
            Scanner in = new Scanner(new FileInputStream(file));
            boolean found = false;
            while (!found && in.hasNextLine())
            {
                String line = in.nextLine();
                if (line.contains(this.keyword))
                {
                    found = true;
                }
            }
            in.close();
            return found;
        }
        catch (IOException e)
        {
            return false;
        }
    }
}
