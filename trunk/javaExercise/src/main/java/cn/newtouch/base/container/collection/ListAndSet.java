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
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ListAndSet
{

    /**
     * Description of this Method
     * 
     * @since 2010-12-15
     * @author LoToS
     * @param args
     */
    public static void main(String[] args)
    {
        Set<String> strs = new HashSet<String>();
        List<String> interim = new ArrayList<String>();
        interim.add("123123");
        interim.add("234234");
        interim.add("345345");
        interim.add("456456");
        interim.add("567567");
        interim.add("678678");
        interim.add("789789");
        interim.add("890890");
        interim.add("901901");
        interim.add("012012");
        interim.add("121212");
        interim.add("232323");
        interim.add("343434");
        interim.add("454545");
        interim.add("565656");
        List<String> sss = interim.subList(0, 5);
        System.out.println("=============================");
        System.out.println(sss.size());
        for (String aa : sss)
        {
            System.out.println(aa);
        }
        System.out.println("=============================");
        strs.addAll(interim);

        int aaa = strs.size();

        strs.add("aaadsdas");
        System.out.println(aaa);
        System.out.println(strs.size());

        System.out.println("=============================");

        Map<String, String> map = new HashMap<String, String>();

        map.put("123", "abc");

        map.put("345", "cde");

        map.put("567", "efg");

        Set<Map.Entry<String, String>> set = map.entrySet();

        for (Map.Entry<String, String> asdasd : set)
        {

            System.out.println("Key is " + asdasd.getKey() + ", Value is "
                    + asdasd.getValue() + ".");
        }

    }

}
