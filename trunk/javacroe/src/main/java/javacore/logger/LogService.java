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
package javacore.logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class LogService
{

    private static LogService logService;

    private static Logger     logger;

    private LogService()
    {
    }

    public static LogService getLogger(Class clazz, String resourceName)
    {
        if (null != logService)
        {
            return logService;
        }
        else
        {
            logService = new LogService();
            try
            {
                InputStream in = new FileInputStream(new File(LogService.class.getClassLoader()
                        .getResource("log.properties").getPath()));

                LogManager logManager = LogManager.getLogManager();
                // 重新初始化日志属性并重新读取日志配置。
                logManager.readConfiguration(in);
                logger = Logger.getLogger(clazz.getName(), resourceName);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            return logService;
        }
    }

    public void log(Level level, String msg)
    {
        logger.log(level, msg);
    }

    public void log(Level level, String msg, Object params[])
    {
        logger.log(level, msg, params);
    }

    public static void main(String[] args)
    {
        LogService log = LogService.getLogger(LogService.class, "logger");
        log.log(Level.SEVERE, "天哪 出了错了");
        log.log(Level.WARNING, "logger.org.hibernate", new Object[] { "ye!", "2" });
    }
}