//-------------------------------------------------------------------------
// Copyright (c) 2000-2010 Digital. All Rights Reserved.
//
// This software is the confidential and proprietary information of
// Digital
//
// Original author: Administrator
//
//-------------------------------------------------------------------------
// LOOSOFT MAKES NO REPRESENTATIONS OR WARRANTIES ABOUT THE SUITABILITY OF
// THE SOFTWARE, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED
// TO THE IMPLIED WARRANTIES OF MERCHANTABILITY, FITNESS FOR A
// PARTICULAR PURPOSE, OR NON-INFRINGEMENT. UFINITY SHALL NOT BE
// LIABLE FOR ANY DAMAGES SUFFERED BY LICENSEE AS A RESULT OF USING,
// MODIFYING OR DISTRIBUTING THIS SOFTWARE OR ITS DERIVATIVES.
//
// THIS SOFTWARE IS NOT DESIGNED OR INTENDED FOR USE OR RESALE AS ON-LINE
// CONTROL EQUIPMENT IN HAZARDOUS ENVIRONMENTS REQUIRING FAIL-SAFE
// PERFORMANCE, SUCH AS IN THE OPERATION OF NUCLEAR FACILITIES, AIRCRAFT
// NAVIGATION OR COMMUNICATION SYSTEMS, AIR TRAFFIC CONTROL, DIRECT LIFE
// SUPPORT MACHINES, OR WEAPONS SYSTEMS, IN WHICH THE FAILURE OF THE
// SOFTWARE COULD LEAD DIRECTLY TO DEATH, PERSONAL INJURY, OR SEVERE
// PHYSICAL OR ENVIRONMENTAL DAMAGE ("HIGH RISK ACTIVITIES"). UFINITY
// SPECIFICALLY DISCLAIMS ANY EXPRESS OR IMPLIED WARRANTY OF FITNESS FOR
// HIGH RISK ACTIVITIES.
//-------------------------------------------------------------------------
package javacore.timer;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Timer;

public class TimerTest
{

    public static void main(String[] args)
    {
        // timer1();
        // timer2();
        timer3();
        // timer4();
    }

    public static void timer1()
    {
        Timer timer = new Timer();
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS").format(new Date()));
        timer.schedule(new TimerTaskTest(), 3000);// 3000毫秒之后运行
    }

    public static void timer2()
    {
        Calendar calendar = new GregorianCalendar();
        calendar.add(Calendar.MINUTE, 1);
        calendar.set(Calendar.SECOND, 0); // 一分钟后执行
        Timer timer = new Timer();
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS").format(new Date()));
        timer.schedule(new TimerTaskTest(), calendar.getTime());
    }

    public static void timer3()
    {
        Timer timer = new Timer();
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS").format(new Date()));
        timer.schedule(new TimerTaskTest(), 10000, 3000);// 3000毫秒之后运行,此后每3000毫秒运行一次
    }

    public static void timer4()
    {
        Calendar calendar = new GregorianCalendar();
        calendar.set(Calendar.MINUTE, 1); // 控制分
        calendar.set(Calendar.SECOND, 30); // 控制秒 一分半之后执行
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS").format(new Date()));
        Timer timer = new Timer();
        timer.schedule(new TimerTaskTest(), calendar.getTime(), 3000);
    }
}