package com.hnmmli.thread.thetimer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerTest
{

    public static void main(String[] args) throws ParseException
    {
        System.out.println("now===" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        Timer myTimer = new Timer();
        // 1秒后执行
        myTimer.schedule(new MyTimer(1), 1000);
        // 指定时间执行
        myTimer.schedule(new MyTimer(2), new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2014-05-18 19:51:00"));
        // 5秒后执行 每10秒执行1次
        myTimer.schedule(new MyTimer(3), 5000, 10000);
        // 指定时间执行1次 以后每10秒执行1次，如果设定的时间点在当前时间之前，任务会被马上执行，然后开始按照设定的周期定时执行任务
        myTimer.schedule(new MyTimer(4), new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2014-05-18 19:51:00"),
                10000);
        // 5秒后执行 每5秒执行1次 如果该任务因为某些原因（例如垃圾收集）而延迟执行，那么接下来的任务会尽可能的快速执行，以赶上特定的时间点
        myTimer.scheduleAtFixedRate(new MyTimer(5), 5000, 5000);
        // 指定时间执行1次 以后每3秒执行1次 其他如上
        myTimer.scheduleAtFixedRate(new MyTimer(6),
                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2014-05-18 19:51:00"), 3000);

        // （1）schedule方法：“fixed-delay”；如果第一次执行时间被delay了，随后的执行时间按 照 上一次 实际执行完成的时间点 进行计算
        // （2）scheduleAtFixedRate方法：“fixed-rate”；如果第一次执行时间被delay了，随后的执行时间按照上一次开始的 时间点 进行计算，
        // 并且为了”catch up”会多次执行任务,TimerTask中的执行体需要考虑同步
    }
}

class MyTimer extends TimerTask
{
    private int index;

    public MyTimer(int index)
    {
        this.index = index;
    }

    @Override
    public void run()
    {
        System.out.println("===" + this.index + "我被执行了！" + "时间是："
                + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }

}
