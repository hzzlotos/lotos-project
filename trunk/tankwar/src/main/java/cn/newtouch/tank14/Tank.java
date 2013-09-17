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
package cn.newtouch.tank14;

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
    private int     x                = 5;

    // 坦克定位Y,默认值为23
    private int     y                = 23;

    // 坦克宽度,默认值为30
    private int     width            = 30;

    // 坦克高度,默认值为30
    private int     height           = 30;

    // 坦克颜色,默认值为红色
    private Color   color            = Color.RED;

    // 坦克的方向,默认值为停止
    private int     direction        = Constants.STOP;

    // 炮筒的方向,默认值为向左
    private int     barrel_direction = Constants.LEFT;

    // 坦克的键盘上的左方向键是否被按
    private boolean isLeft;

    // 坦克的键盘上的上方向键是否被按
    private boolean isUp;

    // 坦克的键盘上的右方向键是否被按
    private boolean isRight;

    // 坦克的键盘上的下方向键是否被按
    private boolean isDown;

    // 坦克的步伐,默认值为5
    private int     pace             = 5;

    // 坦克是否还在
    private boolean live             = true;

    public int getX()
    {
        return x;
    }

    public void setX(int x)
    {
        this.x = x;
    }

    public int getY()
    {
        return y;
    }

    public void setY(int y)
    {
        this.y = y;
    }

    public int getWidth()
    {
        return width;
    }

    public void setWidth(int width)
    {
        this.width = width;
    }

    public int getHeight()
    {
        return height;
    }

    public void setHeight(int height)
    {
        this.height = height;
    }

    public Color getColor()
    {
        return color;
    }

    public void setColor(Color color)
    {
        this.color = color;
    }

    public int getDirection()
    {
        return direction;
    }

    public void setDirection(int direction)
    {
        this.direction = direction;
    }

    public int getBarrel_direction()
    {
        return barrel_direction;
    }

    public void setBarrel_direction(int barrelDirection)
    {
        barrel_direction = barrelDirection;
    }

    public boolean isLeft()
    {
        return isLeft;
    }

    public void setLeft(boolean isLeft)
    {
        this.isLeft = isLeft;
    }

    public boolean isUp()
    {
        return isUp;
    }

    public void setUp(boolean isUp)
    {
        this.isUp = isUp;
    }

    public boolean isRight()
    {
        return isRight;
    }

    public void setRight(boolean isRight)
    {
        this.isRight = isRight;
    }

    public boolean isDown()
    {
        return isDown;
    }

    public void setDown(boolean isDown)
    {
        this.isDown = isDown;
    }

    public int getPace()
    {
        return pace;
    }

    public void setPace(int pace)
    {
        this.pace = pace;
    }

    public boolean isLive()
    {
        return live;
    }

    public void setLive(boolean live)
    {
        this.live = live;
    }
}