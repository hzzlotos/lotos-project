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
package cn.newtouch.tank19;

import java.awt.Color;

import cn.newtouch.tank19.Constants.Direction;

/**
 * 
 * 坦克对象
 * 
 * @author zzHe
 * @version 1.0
 * @since 2012-6-12
 */
public class Tank extends BaseObject
{
    // 炮筒的方向,默认值为向左
    private Direction barrel_direction = Direction.LEFT;

    // 坦克的键盘上的左方向键是否被按
    private boolean   isLeft;

    // 坦克的键盘上的上方向键是否被按
    private boolean   isUp;

    // 坦克的键盘上的右方向键是否被按
    private boolean   isRight;

    // 坦克的键盘上的下方向键是否被按
    private boolean   isDown;

    private int       step;

    public Direction getBarrel_direction()
    {
        return barrel_direction;
    }

    public void setBarrel_direction(Direction barrelDirection)
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

    /**
     * 
     * 初始化我方坦克
     * 
     * @since 2012-6-14
     * @param color
     *            颜色
     */
    public Tank(Color color)
    {
        // 初始化默认值
        this.x = 5;
        this.y = 23;
        this.width = 30;
        this.height = 30;
        this.color = color;
        this.direction = Direction.LEFT;
        this.barrel_direction = Direction.LEFT;
        this.pace = 5;
        this.robot = false;
    }

    /**
     * 
     * 初始化机器人坦克
     * 
     * @since 2012-6-14
     * @param x
     *            X坐标
     * @param y
     *            Y坐标
     */
    public Tank(int x, int y, Direction direction)
    {
        // 默认初始化
        this.x = x;
        this.y = y;
        this.width = 30;
        this.height = 30;
        // 机器人 默认为黄色
        this.color = Constants.TANK_COLOR_OTHER;
        this.direction = direction;
        this.barrel_direction = direction;
        this.pace = 5;
        // 设置为机器人
        this.robot = true;
    }

    public Tank()
    {
        this.x = 5;
        this.y = 23;
        this.width = 30;
        this.height = 30;
        this.color = Constants.TANK_COLOR;
        this.direction = Direction.LEFT;
        this.pace = 5;
        this.live = true;
        this.robot = true;
        this.barrel_direction = Direction.LEFT;
        this.isLeft = false;
        this.isUp = false;
        this.isRight = false;
        this.isDown = false;
    }

    public int getStep()
    {
        return step;
    }

    public void setStep(int step)
    {
        this.step = step;
    }
}