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
package cn.newtouch.tank08;

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

    // 坦克定位X,默认值为5
    private int     tank_x         = 5;

    // 坦克定位Y,默认值为23
    private int     tank_y         = 23;

    // 坦克宽度,默认值为30
    private int     tank_width     = 30;

    // 坦克高度,默认值为30
    private int     tank_height    = 30;

    // 坦克颜色,默认值为红色
    private Color   tank_color     = Color.RED;

    // 坦克的方向,默认值为停止
    private int     tank_direction = Constants.TANK_STOP;

    // 坦克的键盘上的左方向键是否被按
    private boolean tank_isleft;

    // 坦克的键盘上的上方向键是否被按
    private boolean tank_isup;

    // 坦克的键盘上的右方向键是否被按
    private boolean tank_isright;

    // 坦克的键盘上的下方向键是否被按
    private boolean tank_isdown;

    // 坦克的步伐,默认值为5
    private int     tank_pace      = 5;

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

    public int getTank_pace()
    {
        return tank_pace;
    }

    public void setTank_pace(int tankPace)
    {
        tank_pace = tankPace;
    }

    public int getTank_direction()
    {
        return tank_direction;
    }

    public void setTank_direction(int tankDirection)
    {
        tank_direction = tankDirection;
    }

    public boolean isTank_isleft()
    {
        return tank_isleft;
    }

    public void setTank_isleft(boolean tankIsleft)
    {
        tank_isleft = tankIsleft;
    }

    public boolean isTank_isup()
    {
        return tank_isup;
    }

    public void setTank_isup(boolean tankIsup)
    {
        tank_isup = tankIsup;
    }

    public boolean isTank_isright()
    {
        return tank_isright;
    }

    public void setTank_isright(boolean tankIsright)
    {
        tank_isright = tankIsright;
    }

    public boolean isTank_isdown()
    {
        return tank_isdown;
    }

    public void setTank_isdown(boolean tankIsdown)
    {
        tank_isdown = tankIsdown;
    }
}