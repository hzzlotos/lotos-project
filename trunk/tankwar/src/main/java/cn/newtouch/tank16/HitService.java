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
package cn.newtouch.tank16;

import java.util.List;

public class HitService
{
    public static void hit(List<Tank> tankList, List<Missile> missileList)
    {
        Missile missile;
        Tank tank;
        Tank tank2;
        for (int i = 0; i < missileList.size(); i++)
        {
            missile = missileList.get(i);
            for (int j = 0; j < tankList.size(); j++)
            {
                tank = tankList.get(j);
                if (missile.getRectangle().intersects(tank.getRectangle())
                        && missile.isLive() && tank.isLive()
                        && missile.isRobot() != tank.isRobot())
                {
                    tank.setLive(false);
                    missile.setLive(false);
                }
            }
        }
        for (int i = 0; i < tankList.size(); i++)
        {
            tank = tankList.get(i);
            for (int j = 0; j < tankList.size(); j++)
            {
                tank2 = tankList.get(j);
                if (tank2.getRectangle().intersects(tank.getRectangle())
                        && tank2.isLive() && tank.isLive()
                        && tank2.isRobot() != tank.isRobot())
                {
                    if (!tank.isRobot())
                    {
                        tank.setLive(false);
                    }
                    if (!tank2.isRobot())
                    {
                        tank2.setLive(false);
                    }
                }
            }
        }
    }
}
