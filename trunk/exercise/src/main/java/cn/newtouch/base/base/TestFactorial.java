//-------------------------------------------------------------------------
// Copyright (c) 2000-2010 Digital. All Rights Reserved.
//
// This software is the confidential and proprietary information of
// Digital
//
// Original author: zzHe
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
package cn.newtouch.base.base;

import java.util.HashSet;
import java.util.Set;

//阶乘
public class TestFactorial
{
    private String[]    shuzijihe = new String[] { "1", "2", "3", "4" };

    private Set<String> sets      = new HashSet<String>();

    public static void main(String[] args)
    {
        new TestFactorial().start();

    }

    private void start()
    {
        for (String shuzi : shuzijihe)
        {
            depthFirstSearch(shuzi);
        }
        System.out.println(sets.size());
        for (String str : sets)
        {
            System.out.println("===" + str);
        }
    }

    private void depthFirstSearch(String str)
    {
        if (str.length() == shuzijihe.length)
        {
            sets.add(str);
        }
        else
        {
            for (String shuzi : shuzijihe)
            {
                if (str.indexOf(shuzi) < 0)
                {
                    String ccc = str + shuzi;
                    depthFirstSearch(ccc);
                }
            }
        }
    }
}