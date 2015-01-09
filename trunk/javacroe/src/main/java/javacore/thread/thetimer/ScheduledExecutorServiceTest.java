package javacore.thread.thetimer;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

//传统的timer的缺点：Timer对任务的调度是基于绝对时间的；所有的TimerTask只有一个线程TimerThread来执行，
//因此同一时刻只有一个TimerTask在执行；任何一个TimerTask的执行异常都会导致Timer终止所有任务；由于基于绝对时间并且是单线程执行，
//因此在多个任务调度时，长时间执行的任务被执行后有可能导致短时间任务快速在短时间内被执行多次或者干脆丢弃多个任务。
public class ScheduledExecutorServiceTest
{
    public static void main(String[] args) throws Exception
    {
        // test();
        executeEightAtNightPerDay();
    }

    private static void test() throws Exception
    {
        ScheduledExecutorService execService = Executors.newScheduledThreadPool(3);
        // 5秒后开始执行 每个2秒执行一次，如果有的任务执行要花费比其周期更长的时间，则将推迟后续执行，但不会同时执行
        // 每次相隔相同的时间执行任务，如果任务的执行时间比周期还长，那么下一个任务将立即执行
        execService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run()
            {
                System.out.println("任务：" + Thread.currentThread().getName() + " 执行了，时间为： " + System.currentTimeMillis());
                try
                {
                    Thread.sleep(1000L);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        }, 5, 30, TimeUnit.SECONDS);
        // 5秒后开始执行 每个2秒执行一次，保证固定的延迟为2秒 下一个任务的开始时间与上一个任务的结束时间间隔相同
        execService.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run()
            {
                System.out.println("任务：" + Thread.currentThread().getName() + "执行了，时间为：" + System.currentTimeMillis());
                try
                {
                    Thread.sleep(1000L);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        }, 5, 2, TimeUnit.SECONDS);
        Thread.sleep(10000L);
        execService.shutdown();
    }

    /**
     * 每天固定时间执行1次
     * 每天定时安排任务进行执行
     */
    private static void executeEightAtNightPerDay()
    {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        long oneDay = 24 * 60 * 60 * 1000;
        long initDelay = getTimeMillis("20:52:00") - System.currentTimeMillis();
        initDelay = initDelay > 0 ? initDelay : oneDay + initDelay;
        executor.scheduleAtFixedRate(new EchoServer(), initDelay, oneDay, TimeUnit.MILLISECONDS);
    }

    /**
     * 获取指定时间对应的毫秒数
     * 
     * @param time "HH:mm:ss"
     * @return
     */
    private static long getTimeMillis(String time)
    {
        try
        {
            DateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
            DateFormat dayFormat = new SimpleDateFormat("yy-MM-dd");
            Date curDate = dateFormat.parse(dayFormat.format(new Date()) + " " + time);
            return curDate.getTime();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return 0;
    }
}

class EchoServer implements Runnable
{
    @Override
    public void run()
    {
        try
        {
            Thread.sleep(50);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        System.out.println("This is a echo server. The current time is "
                + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + ".");
    }
}