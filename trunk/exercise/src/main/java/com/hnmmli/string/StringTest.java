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
package com.hnmmli.string;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class StringTest
{
    public static void main(String[] args)
    {
        // consoleIn();
        consoleOut();
        // equals();
        // getChar();
    }

    private static List<String> getInWithConsole()
    {
        List<String> list = new ArrayList();
        // 读取控制台
        Scanner in = new Scanner(System.in);
        String temp = in.nextLine();
        while (null != temp && !"".equals(temp) && !"is end".equals(temp))
        {
            list.add(temp);
            temp = in.nextLine();
        }
        return list;
    }

    private static void consoleOut()
    {
        // 控制台输出格式化
        System.out.format("%,8.2f ==== %s", 10000.0 / 3.0, "aaaa");
        System.out.println("\n");
        System.out.printf("%tc", new Date());
    }

    private static void consoleIn()
    {
        List<String> temps = getInWithConsole();
        if (null != temps && !temps.isEmpty())
        {
            for (String temp : temps)
            {
                System.out.println("===" + temp);
            }
        }

    }

    private static void getChar()
    {
        String temp = "hello好";
        int cpCount = temp.codePointCount(0, temp.length());
        System.out.println("cpCount====" + cpCount);
        char first = temp.charAt(0);
        char last = temp.charAt(cpCount - 1);
        System.out.println("first===" + first);
        System.out.println("last===" + last);
        int index = temp.offsetByCodePoints(0, 5);
        System.out.println("index===" + index);
        int cp = temp.codePointAt(index);
        System.out.println("cp===" + cp);
        System.out.println((char) cp);
    }

    private static void equals()
    {
        String aaa = "111";
        String bbb = "111";
        String ccc = new String("111");
        String ddd = "222";
        String eee = new String("111111").substring(1, 4);
        System.out.println(aaa.hashCode());
        System.out.println(bbb.hashCode());
        System.out.println(ccc.hashCode());
        System.out.println(ddd.hashCode());
        System.out.println(eee + "===" + eee.hashCode());
        System.out.println("==============================");
        // 比较的是地址是否相等
        System.out.println(aaa == bbb);
        System.out.println(aaa == ccc);
        System.out.println(aaa == ddd);
        System.out.println(aaa == eee);
        System.out.println("==============================");
        // 比较的字符是否相等
        System.out.println(aaa.equals(bbb));
        System.out.println(aaa.equals(ccc));
        System.out.println(aaa.equals(ddd));
        System.out.println(aaa.equals(eee));
    }
}
