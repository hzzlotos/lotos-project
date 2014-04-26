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
package com.hnmmli.bigDecimal;

import java.math.BigDecimal;

public class BigDecimalTest
{
    public static void main(String[] args)
    {
        BigDecimal bigDecimal1 = new BigDecimal(10.0F), bigDecimal3;
        BigDecimal bigDecimal2 = new BigDecimal(5.0D);
        bigDecimal3 = bigDecimal1.add(bigDecimal2);// +
        System.out.println(bigDecimal3.doubleValue());

        bigDecimal3 = bigDecimal1.subtract(bigDecimal2);// -
        System.out.println(bigDecimal3.doubleValue());

        bigDecimal3 = bigDecimal1.multiply(bigDecimal2);// *
        System.out.println(bigDecimal3.doubleValue());

        bigDecimal3 = bigDecimal1.divide(bigDecimal2);// /
        System.out.println(bigDecimal3.doubleValue());

        System.out.println(bigDecimal1.compareTo(bigDecimal2));

        System.out.println(bigDecimal2.compareTo(bigDecimal1));
    }
}
