package com.hnmmli.thread.corejava;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class MatchCounter implements Callable<Integer>
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
