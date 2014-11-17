package cn.newtouch.proxy.treadlocal.yes;

public class NumCreator
{
    private static ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>();

    public NumCreator()
    {
    }

    public Integer getNextNum()
    {
        Integer num = threadLocal.get();
        if (null == num)
        {
            threadLocal.set(1);
        }
        else
        {
            threadLocal.set(num + 1);
        }
        return threadLocal.get();
    }
}
