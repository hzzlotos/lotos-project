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
package cn.newtouch.base.file.stream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class StringProperties
{

    /**
     * Description of this Method
     * 
     * @since 2010-12-21
     * @author zzHe
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException
    {
        String str = null;

        List<String> stringList = new ArrayList<String>();

        File inf = new File("d:\\mycourse_manage_schedule.htm");

        FileInputStream fis = new FileInputStream(inf);

        InputStreamReader isr = new InputStreamReader(fis, "ISO-8859-1");

        BufferedReader br = new BufferedReader(isr);

        while ((str = br.readLine()) != null)
        {
            stringList.add(str);
        }

        br.close();
        isr.close();
        fis.close();

        File outf = new File("d:\\", "aaa.html");

        FileOutputStream fos = new FileOutputStream(outf);

        OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");

        BufferedWriter bw = new BufferedWriter(osw);

        for (String aaa : stringList)
        {
            String s = new String(aaa.getBytes("ISO-8859-1"), "UTF-8");
            bw.write(s.concat("\n"));
        }

        bw.close();
        osw.close();
        fos.close();

    }
}
