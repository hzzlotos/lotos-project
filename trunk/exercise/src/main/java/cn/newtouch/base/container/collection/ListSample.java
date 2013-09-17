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
package cn.newtouch.base.container.collection;

import java.util.ArrayList;
import java.util.List;

public class ListSample
{

    public static void main(String[] args)
    {
        List<String> all = new ArrayList<String>();
        all.add("123");
        all.add("234");
        all.add("345");
        all.add("456");
        all.add("567");
        for (int i = 10; i < all.size(); i++)
        {
            System.out.println(all.get(i));
        }
        System.out.println("=====================1=====================");
        System.out.print(all.get(0));
        all.remove(3);
        System.out.print(all.get(3));
        for (String str : all)
        {
            System.out.println(str);
        }
        System.out.println("=====================2=====================");
        List<String> aaa = new ArrayList<String>();

        String sss = "123";
        aaa.add(sss);

        sss = "1";

        System.out.println(aaa.get(0));

        aaa.add("222");

        aaa.add("333");

        List<String> bbb = new ArrayList<String>();

        bbb.add("222");
        bbb.add("444");
        bbb.add("555");

        for (String str1 : aaa)
        {
            for (String str2 : bbb)
            {
                if (str1.equals(str2))
                {
                    System.out.println("true");
                    System.out.println("====================");
                    break;
                }
            }
            System.out.println("false");
            System.out.println("||||||||||||||||||||");
        }
    }
}
