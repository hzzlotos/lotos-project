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
package cn.newtouch.tank18;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
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
    /**
     * 
     * 画坦克
     * 
     * @since 2012-6-12
     * @author zzHe
     * @param g
     *            画笔
     * @param tankList
     *            坦克列表
     */
    public static void draw(Graphics g, List<Tank> tankList)
    {
        for (Tank tank : tankList)
        {
            if (tank.isLive())
            {
                draw(g, tank);
                move(tank);
            }
            else
            {
                // tankList.remove(tank);
            }
        }
    }

    // 画坦克以及炮筒
    private static void draw(Graphics g, Tank tank)
    {
        // 坦克
        Color c = g.getColor();
        g.setColor(tank.getColor());
        // 方块
        g.fillRect(tank.getX(), tank.getY(), tank.getWidth(), tank.getHeight());
        g.setColor(c);
        // 炮筒
        c = g.getColor();
        g.setColor(Constants.BARREL_COLOR);
        // 坦克X,Y以及坦克长宽的一半以用作计算
        int x1 = tank.getX();
        int y1 = tank.getY();
        int x2 = tank.getWidth() / 2;
        int y2 = tank.getHeight() / 2;
        // 炮筒的一点固定为坦克中心位置(x1+x2,y1+y2)
        switch (tank.getBarrel_direction())
        {
        case Constants.LEFT:
            g.drawLine(x1 + x2 - (int) (x2 * Math.sqrt(2)), y1 + y2, x1 + x2,
                    y1 + y2);
            break;
        case Constants.UP:
            g.drawLine(x1 + x2, y1 + y2 - (int) (y2 * Math.sqrt(2)), x1 + x2,
                    y1 + y2);
            break;
        case Constants.RIGHT:
            g.drawLine(x1 + x2 + (int) (x2 * Math.sqrt(2)), y1 + y2, x1 + x2,
                    y1 + y2);
            break;
        case Constants.DOWN:
            g.drawLine(x1 + x2, y1 + y2 + (int) (y2 * Math.sqrt(2)), x1 + x2,
                    y1 + y2);
            break;
        case Constants.LEFT_UP:
            g.drawLine(x1, y1, x1 + x2, y1 + y2);
            break;
        case Constants.RIGHT_UP:
            g.drawLine(x1 + 2 * x2, y1, x1 + x2, y1 + y2);
            break;
        case Constants.RIGHT_DOWN:
            g.drawLine(x1 + 2 * x2, y1 + 2 * y2, x1 + x2, y1 + y2);
            break;
        case Constants.LEFT_DOWN:
            g.drawLine(x1, y1 + 2 * y2, x1 + x2, y1 + y2);
            break;
        default:
            g.drawLine(x1 + x2 - (int) (x2 * Math.sqrt(2)), y1 + y2, x1 + x2,
                    y1 + y2);
        }
        g.setColor(c);
    }

    /**
     * 
     * 坦克移动
     * 
     * @since 2012-6-12
     * @author zzHe
     * @param tank
     *            坦克
     */
    private static void move(Tank tank)
    {
        switch (tank.getDirection())
        {
        case Constants.LEFT:
            if (tank.getX() > tank.getPace())
            {
                tank.setX(tank.getX() - tank.getPace());
            }
            break;
        case Constants.UP:
            if (tank.getY() > tank.getPace() + Constants.UP_NUM)
            {
                tank.setY(tank.getY() - tank.getPace());
            }
            break;
        case Constants.RIGHT:
            if (tank.getX() < (Constants.BACK_WIDTH - tank.getPace() - tank
                    .getWidth()))
            {
                tank.setX(tank.getX() + tank.getPace());
            }
            break;
        case Constants.DOWN:
            if (tank.getY() < (Constants.BACK_HEIGHT - tank.getPace() - tank
                    .getHeight()))
            {
                tank.setY(tank.getY() + tank.getPace());
            }
            break;
        case Constants.LEFT_UP:
            if (tank.getX() > tank.getPace())
            {
                tank.setX(tank.getX() - tank.getPace());
            }
            if (tank.getY() > tank.getPace() + Constants.UP_NUM)
            {
                tank.setY(tank.getY() - tank.getPace());
            }
            break;
        case Constants.RIGHT_UP:
            if (tank.getY() > tank.getPace() + Constants.UP_NUM)
            {
                tank.setY(tank.getY() - tank.getPace());
            }
            if (tank.getX() < (Constants.BACK_WIDTH - tank.getPace() - tank
                    .getWidth()))
            {
                tank.setX(tank.getX() + tank.getPace());
            }
            break;
        case Constants.RIGHT_DOWN:
            if (tank.getX() < (Constants.BACK_WIDTH - tank.getPace() - tank
                    .getWidth()))
            {
                tank.setX(tank.getX() + tank.getPace());
            }
            if (tank.getY() < (Constants.BACK_HEIGHT - tank.getPace() - tank
                    .getHeight()))
            {
                tank.setY(tank.getY() + tank.getPace());
            }
            break;
        case Constants.LEFT_DOWN:
            if (tank.getX() > tank.getPace())
            {
                tank.setX(tank.getX() - tank.getPace());
            }
            if (tank.getY() < (Constants.BACK_HEIGHT - tank.getPace() - tank
                    .getHeight()))
            {
                tank.setY(tank.getY() + tank.getPace());
            }
            break;
        case Constants.STOP:
            break;
        default:
            break;
        }
    }

    /**
     * 
     * 坦克移动
     * 
     * @since 2012-6-12
     * @author zzHe
     * @param tank
     *            坦克
     */
    public static void changeDirection(Tank tank)
    {
        // 左
        if (tank.isLeft() && !tank.isUp() && !tank.isRight() && !tank.isDown())
        {
            tank.setDirection(Constants.LEFT);
        }
        else
            // 上
            if (!tank.isLeft() && tank.isUp() && !tank.isRight()
                    && !tank.isDown())
            {
                tank.setDirection(Constants.UP);
            }
            else
                // 右
                if (!tank.isLeft() && !tank.isUp() && tank.isRight()
                        && !tank.isDown())
                {
                    tank.setDirection(Constants.RIGHT);
                }
                else
                    // 下
                    if (!tank.isLeft() && !tank.isUp() && !tank.isRight()
                            && tank.isDown())
                    {
                        tank.setDirection(Constants.DOWN);
                    }
                    else
                        // 左上
                        if (tank.isLeft() && tank.isUp() && !tank.isRight()
                                && !tank.isDown())
                        {
                            tank.setDirection(Constants.LEFT_UP);
                        }
                        else
                            // 右上
                            if (!tank.isLeft() && tank.isUp() && tank.isRight()
                                    && !tank.isDown())
                            {
                                tank.setDirection(Constants.RIGHT_UP);
                            }
                            else
                                // 右下
                                if (!tank.isLeft() && !tank.isUp()
                                        && tank.isRight() && tank.isDown())
                                {
                                    tank.setDirection(Constants.RIGHT_DOWN);
                                }
                                else
                                    // 左下
                                    if (tank.isLeft() && !tank.isUp()
                                            && !tank.isRight() && tank.isDown())
                                    {
                                        tank.setDirection(Constants.LEFT_DOWN);
                                    }
                                    else
                                    {
                                        tank.setDirection(Constants.STOP);
                                    }
        if (tank.getDirection() != Constants.STOP)
        {
            tank.setBarrel_direction(tank.getDirection());
        }
    }

    public static List<Tank> createTank(int index)
    {
        List<Tank> tanks = new ArrayList<Tank>();
        Tank tank = new Tank();
        for (int i = 0; i < index; i++)
        {
            tank = new Tank(100 + (i + 1) * 70, 50 + (i + 1) * 50);
            tanks.add(tank);
        }
        return tanks;
    }
}