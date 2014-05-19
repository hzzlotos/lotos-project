package com.hnmmli.thread.corejava;

import java.io.File;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.google.common.collect.Lists;

public class ExecutorCompletionServiceTest
{
    public static void main(String[] args) throws Exception
    {
        solve();
    }

    private static void solve() throws Exception
    {
        String directory = "E://test//queue";
        String keyword1 = "a";
        String keyword2 = "b";
        String keyword3 = "c";

        ExecutorService pool = Executors.newCachedThreadPool();

        MatchCounter counter1 = new MatchCounter(new File(directory), keyword1, pool);
        MatchCounter counter2 = new MatchCounter(new File(directory), keyword2, pool);
        MatchCounter counter3 = new MatchCounter(new File(directory), keyword3, pool);
        List<MatchCounter> list = Lists.newArrayList();
        list.add(counter1);
        list.add(counter2);
        list.add(counter3);

        // ==========================1=====================================
        List<Future<Integer>> result = pool.invokeAll(list);
        for (Future<Integer> r : result)
        {
            System.out.println("---------" + r.get());
        }

        // ==========================2===================================
        CompletionService<Integer> ecs = new ExecutorCompletionService<Integer>(pool);
        for (Callable<Integer> s : list)
        {
            ecs.submit(s);
        }
        int n = list.size();
        for (int i = 0; i < n; ++i)
        {
            Integer r = ecs.take().get();
            System.out.println("=========" + r);
        }
    }
}