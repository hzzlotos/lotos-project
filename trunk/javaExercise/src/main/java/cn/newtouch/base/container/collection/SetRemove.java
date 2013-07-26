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
package cn.newtouch.base.container.collection;

import java.util.HashSet;
import java.util.Set;

public class SetRemove
{

    /**
     * Description of this Method
     * 
     * @since 2011-12-2
     * @author zzHe
     * @param args
     */
    public static void main(String[] args)
    {
        Example example31 = new Example();
        example31.setId(10);
        Example example32 = new Example();
        example32.setId(9);
        Example example33 = new Example();
        example33.setId(5);
        Example example34 = new Example();
        example34.setId(6);
        Example example21 = new Example();
        example31.setId(2);

        Set<Example> examples = new HashSet<Example>();
        examples.add(example33);// 5
        examples.add(example34);// 6
        example21.setChilds(examples);
        // Example example22 = new Example();
        // example22.setId(8);
        // examples = new HashSet<Example>();
        // examples.add(example31);
        // examples.add(example32);
        // example22.setChilds(examples);

        Example example11 = new Example();
        example11.setId(1);
        examples = new HashSet<Example>();
        examples.add(example21);// 2
        // examples.add(example22);
        example11.setChilds(examples);// 1

        System.out.println("=================================================");
        // =============================================================
        Set<Long> idds = new HashSet<Long>();
        idds.add(1L);
        idds.add(2L);
        idds.add(3L);
        idds.add(4L);
        idds.add(5L);
        idds.add(6L);
        idds.add(7L);
        idds.add(8L);
        idds.add(9L);
        idds.add(10L);

        Set<Long> theids = getIds(example11, idds);

        for (Long ll : theids)
        {
            System.out.println("long =" + ll);
        }
    }

    public static Set<Long> getIds(Example example, Set<Long> ids)
    {
        if (null != ids && !ids.isEmpty())
        {
            ids.remove(example.getId());
            if (null != example.getChilds() && !example.getChilds().isEmpty())
            {
                for (Example child : example.getChilds())
                {
                    ids = getIds(child, ids);
                }
            }
        }
        return ids;
    }
}
