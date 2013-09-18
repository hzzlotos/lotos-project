//-------------------------------------------------------------------------
// Copyright (c) 2000-2010 Digital. All Rights Reserved.
//
// This software is the confidential and proprietary information of
// Digital
//
// Original author: qingang
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
package cn.newtouch.util;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 视频截图类
 * 
 * @author qingang
 * @version 1.0
 * @since 2011-5-3
 */
public class FfmpegUtils
{

    /**
     * 
     * 视频截图
     * 
     * @since 2011-5-3
     * @author qingang
     * @param ffmpegpath
     *            ffmpeg.exe的目录
     * @param inputFilePath
     *            需截图的视频文件全路径（含文件名）
     * @param outFilePath
     *            截出图片存储路径
     * @param outFileName
     *            截出图片名
     * @param imageFormat
     *            截出图片格式（.jpg、.gif等）
     * @param screenTime
     *            截出图片视频定位时间（单位：秒）
     * @param sense
     *            截出图片分辨率（如：210x120）
     * @return 截出图片全路径
     */
    public static String processImg(String ffmpegpath, String inputFilePath,
            String outFilePath, String outFileName, String imageFormat,
            int screenTime, String sense)
    {

        List<String> commend = new ArrayList<String>();
        commend.add(ffmpegpath);
        commend.add("-i");
        commend.add(inputFilePath);
        commend.add("-y");
        commend.add("-f");
        commend.add("image2");
        commend.add("-ss");
        commend.add(String.valueOf(screenTime));
        commend.add("-t");
        commend.add("0.001");
        commend.add("-s");
        commend.add(sense);
        commend.add(outFilePath + outFileName + imageFormat);

        try
        {
            ProcessBuilder builder = new ProcessBuilder();
            builder.command(commend);
            builder.start();
            return outFileName + imageFormat;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

}
