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

/**
 * 
 * 坦克对象
 * 
 * @author zzHe
 * @version 1.0
 * @since 2012-6-12
 */
public class Tank
{

    // 坦克定位X
    private int   tank_x         = 5;

    // 坦克定位Y
    private int   tank_y         = 25;

    // 坦克宽度
    private int   tank_width     = 30;

    // 坦克高度
    private int   tank_height    = 30;

    // 坦克颜色
    private Color tank_color     = Color.RED;

    // 坦克的方向
    private int   tank_direction = 0;

    // 坦克的步伐
    private int   tank_pace      = 5;

    public Tank()
    {
        super();
    }

    public Tank(int tankX, int tankY, int tankWidth, int tankHeight,
            Color tankColor, int tankDirection, int tankPace)
    {
        super();
        tank_x = tankX;
        tank_y = tankY;
        tank_width = tankWidth;
        tank_height = tankHeight;
        tank_color = tankColor;
        tank_direction = tankDirection;
        tank_pace = tankPace;
    }

    public int getTank_x()
    {
        return tank_x;
    }

    public void setTank_x(int tankX)
    {
        tank_x = tankX;
    }

    public int getTank_y()
    {
        return tank_y;
    }

    public void setTank_y(int tankY)
    {
        tank_y = tankY;
    }

    public int getTank_width()
    {
        return tank_width;
    }

    public void setTank_width(int tankWidth)
    {
        tank_width = tankWidth;
    }

    public int getTank_height()
    {
        return tank_height;
    }

    public void setTank_height(int tankHeight)
    {
        tank_height = tankHeight;
    }

    public Color getTank_color()
    {
        return tank_color;
    }

    public void setTank_color(Color tankColor)
    {
        tank_color = tankColor;
    }

    public int getTank_direction()
    {
        return tank_direction;
    }

    public void setTank_direction(int tankDirection)
    {
        tank_direction = tankDirection;
    }

    public int getTank_pace()
    {
        return tank_pace;
    }

    public void setTank_pace(int tankPace)
    {
        tank_pace = tankPace;
    }
}