package cn.newtouch.service;

import java.util.Map;

import com.google.common.collect.Maps;

public class TestService
{
    private static Map<Long, Double> progressMap = Maps.newHashMap();

    public long dosomething()
    {
        DoSomeThing a = new DoSomeThing();
        a.start();
        progressMap.put(a.getId(), null);
        return a.getId();
    }

    public static void setprogress(Long threadId, Double progress)
    {
        System.out.println("the progress" + progress);
        progressMap.put(threadId, progress);
    }

    public static Double getprogress(Long threadId)
    {
        return progressMap.get(threadId);
    }
}