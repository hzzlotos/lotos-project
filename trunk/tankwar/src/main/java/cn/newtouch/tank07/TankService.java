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
package cn.newtouch.tank07;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.List;

/**
 * 
 * 坦克业务处理类
 * 
 * @author zzHe
 * @version 1.0
 * @since 2012-6-12
 */
public class TankService
{

    public void draw(Graphics g, List<Tank> tankList)
    {
        for (Tank tank : tankList)
        {
            // 重新填色
            Color c = g.getColor();
            g.setColor(tank.getTank_color());
            // 画实心圆
            g.fillRect(tank.getTank_x(), tank.getTank_y(),
                    tank.getTank_width(), tank.getTank_height());
            g.setColor(c);
        }
    }

    public void keyPressed(KeyEvent e, Tank tank)
    {
        int keyCode = e.getKeyCode();
        switch (keyCode)
        {
        case KeyEvent.VK_RIGHT:
            if (tank.getTank_x() <= (Constants.BACK_WIDTH - tank.getTank_pace()))
            {
                tank.setTank_x(tank.getTank_x() + tank.getTank_pace());
            }
            break;
        case KeyEvent.VK_LEFT:
            if (tank.getTank_x() >= tank.getTank_pace())
            {
                tank.setTank_x(tank.getTank_x() - tank.getTank_pace());
            }
            break;
        case KeyEvent.VK_UP:
            if (tank.getTank_y() >= tank.getTank_pace() + Constants.UP_NUM)
            {
                tank.setTank_y(tank.getTank_y() - tank.getTank_pace());
            }
            break;
        case KeyEvent.VK_DOWN:
            if (tank.getTank_y() <= (Constants.BACK_HEIGHT - tank
                    .getTank_pace()))
            {
                tank.setTank_y(tank.getTank_y() + tank.getTank_pace());
            }
            break;
        default:
            break;
        }
    }
}