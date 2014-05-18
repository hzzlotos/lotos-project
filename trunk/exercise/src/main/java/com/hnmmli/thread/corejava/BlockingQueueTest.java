package com.hnmmli.thread.corejava;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueTest
{
    public static void main(String[] args)
    {
        final int FILE_QUEUE_SIZE = 10;
        String directory = "E://test//queue";
        String keyword1 = "a";
        String keyword2 = "b";
        String keyword3 = "c";

        BlockingQueue<File> queue = new ArrayBlockingQueue<File>(FILE_QUEUE_SIZE);

        FileEnumerationTask enumerator = new FileEnumerationTask(queue, new File(directory));
        new Thread(enumerator).start();

        new Thread(new SearchTask(queue, keyword1)).start();
        new Thread(new SearchTask(queue, keyword2)).start();
        new Thread(new SearchTask(queue, keyword3)).start();
    }
}

class FileEnumerationTask implements Runnable
{
    public static File          DUMMY = new File("");

    private BlockingQueue<File> queue;

    private File                startingDirectory;

    public FileEnumerationTask(BlockingQueue<File> queue, File startingDirectory)
    {
        this.queue = queue;
        this.startingDirectory = startingDirectory;
    }

    public void enumerate(File directory) throws InterruptedException
    {
        File[] files = directory.listFiles();
        for (File file : files)
        {
            if (file.isDirectory())
            {
                this.enumerate(file);
            }
            else
            {
                this.queue.put(file);
            }
        }
    }

    @Override
    public void run()
    {
        try
        {
            this.enumerate(this.startingDirectory);
            this.queue.put(DUMMY);
        }
        catch (InterruptedException e)
        {
        }
    }
}

class SearchTask implements Runnable
{
    private String              keyword;

    private BlockingQueue<File> queue;

    public SearchTask(BlockingQueue<File> queue, String keyword)
    {
        this.queue = queue;
        this.keyword = keyword;
    }

    @Override
    public void run()
    {
        try
        {
            boolean done = false;
            while (!done)
            {
                File file = this.queue.take();
                if (file == FileEnumerationTask.DUMMY)
                {
                    this.queue.put(file);
                    done = true;
                }
                else
                {
                    this.search(file);
                }
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        catch (InterruptedException e)
        {
        }
    }

    public void search(File file) throws IOException
    {
        Scanner in = new Scanner(new FileInputStream(file));
        int lineNumber = 0;
        while (in.hasNextLine())
        {
            lineNumber++;
            String line = in.nextLine();
            if (line.contains(this.keyword))
            {
                System.out.println(file.getPath() + "   行号:" + lineNumber + "   " + line);
            }
        }
        in.close();
    }
}
