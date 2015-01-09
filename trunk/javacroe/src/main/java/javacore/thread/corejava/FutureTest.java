package javacore.thread.corejava;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class FutureTest
{
    public static void main(String[] args)
    {
        String directory = "E://test//queue";
        String keyword1 = "a";
        String keyword2 = "b";
        String keyword3 = "c";
        MatchCounter1 counter1 = new MatchCounter1(new File(directory), keyword1);
        MatchCounter1 counter2 = new MatchCounter1(new File(directory), keyword2);
        MatchCounter1 counter3 = new MatchCounter1(new File(directory), keyword3);
        FutureTask<Integer> task1 = new FutureTask<Integer>(counter1);
        FutureTask<Integer> task2 = new FutureTask<Integer>(counter2);
        FutureTask<Integer> task3 = new FutureTask<Integer>(counter3);
        Thread t1 = new Thread(task1);
        Thread t2 = new Thread(task2);
        Thread t3 = new Thread(task3);
        t1.start();
        t2.start();
        t3.start();
        try
        {
            System.out.println(task1.get() + "个文件中包含该字符" + keyword1);
            System.out.println(task2.get() + "个文件中包含该字符" + keyword2);
            System.out.println(task3.get() + "个文件中包含该字符" + keyword3);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}

/**
 * This task counts the files in a directory and its subdirectories that contain a given keyword.
 */
class MatchCounter1 implements Callable<Integer>
{
    private int    count;

    private File   directory;

    private String keyword;

    /**
     * Constructs a MatchCounter.
     * 
     * @param directory the directory in which to start the search
     * @param keyword the keyword to look for
     */
    public MatchCounter1(File directory, String keyword)
    {
        this.directory = directory;
        this.keyword = keyword;
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
                    MatchCounter1 counter = new MatchCounter1(file, this.keyword);
                    FutureTask<Integer> task = new FutureTask<Integer>(counter);
                    results.add(task);
                    Thread t = new Thread(task);
                    t.start();
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

    /**
     * Searches a file for a given keyword.
     * 
     * @param file the file to search
     * @return true if the keyword is contained in the file
     */
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