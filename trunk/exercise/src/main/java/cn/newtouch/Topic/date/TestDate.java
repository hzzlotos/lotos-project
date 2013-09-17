//-------------------------------------------------------------------------
// Copyright (c) 2000-2010 Digital. All Rights Reserved.
//
// This software is the confidential and proprietary information of
// Digital
//
// Original author: LoToS
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
package cn.newtouch.Topic.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class TestDate
{
    public static void main(String[] args) throws Exception
    {
        // calendar();
        // simpleDateFormat();
        // getNowDate();
        // parseDate();
        timeZone();
        // java.sql.Date 日期 年月日
        // java.sql.Time 时间 时分秒
        // java.sql.Timestamp 时间戳 年月日时分秒都有的 jdbc取时间的时候常用
    }

    private static void timeZone()
    {
        Calendar cJapan = new GregorianCalendar(TimeZone.getTimeZone("japan"));
        System.out.println(cJapan.get(Calendar.YEAR));
        System.out.println(cJapan.get(Calendar.MONTH));
        System.out.println(cJapan.get(Calendar.DATE));
        System.out.println(cJapan.get(Calendar.HOUR));
        System.out.println(cJapan.get(Calendar.MINUTE));
        System.out.println(cJapan.get(Calendar.SECOND));
        // for (String str : TimeZone.getAvailableIDs())
        // {
        // System.out.println(str);
        // }
    }

    private static void calendar()
    {
        Date d = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(d);

        System.out.println(c.get(Calendar.YEAR));
        // 0代表1月 只有月份需要+1计数
        System.out.println(c.get(Calendar.MONTH));

        System.out.println(c.get(Calendar.DATE));
    }

    private static void simpleDateFormat()
    {
        String datestring = null;
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(datestring = sdf.format(d));
        Date dd = null;
        try
        {
            dd = sdf.parse(datestring);
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }
        System.out.println(sdf.format(dd));
    }

    // 获取当前时间的方法
    private static void getNowDate()
    {
        // 1
        Date d = new Date(System.currentTimeMillis());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(d));
        // 2
        d = new Date();
        // 3
        Calendar c = Calendar.getInstance();
        System.out.println(c.get(Calendar.YEAR));
    }

    // 获取当前时间的方法
    private static void parseDate() throws Exception
    {
        String str = "2000-08-13 08:24:37";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d = sdf.parse(str);
        System.out.println(d.toString());
    }
}
