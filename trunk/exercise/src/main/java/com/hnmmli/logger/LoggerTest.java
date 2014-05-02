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
package com.hnmmli.logger;

import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggerTest
{
    private static Logger logger = Logger.getLogger("com.hnmmli.logger.LoggerTest");

    public static void main(String[] args)
    {
        // 第二参数指包名+文件名去掉".properties",比如需要找该类同级的logger.properties文件 则该参数为'com.hnmmli.logger.logger'
        logger = Logger.getLogger("com.hnmmli.logger.LoggerTest", "logger");
        logger.setLevel(Level.INFO);
        try
        {
            // File file = new File("g:/logs/javalogging.log");
            // file.getParentFile().mkdirs();
            // logger.addHandler(new FileHandler(file.getPath()));
            logger.addHandler(new FileHandler("g:/logs/javalogging.log"));

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        logger.info("俺不管,俺要吃三套鸭!");
        logger.warning("俺不管,俺要吃三套鸭!");
        logger.log(Level.WARNING, "俺不管,俺要吃三套鸭!");
        // 第三参数为配置文件中指定的参数数组
        logger.log(Level.WARNING, "logger.org.hibernate", new Object[] { "ye!", "2" });
        getName("三套鸭", 123);
    }

    private static String getName(String name, int type)
    {
        logger.log(Level.INFO, "方法开始");
        String result = name + type;
        try
        {
            throw new NullPointerException();
        }
        catch (Exception e)
        {
            logger.log(Level.SEVERE, "出错了", e);
        }
        return result;
    }
}