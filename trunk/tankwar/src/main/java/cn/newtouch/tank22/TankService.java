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
package cn.newtouch.tank22;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import cn.newtouch.tank19.Constants.Direction;

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
    private static Random r = new Random();

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
    public static void draw(Graphics g, List<Tank> tankList,
            List<Missile> missileList)
    {
        for (Tank tank : tankList)
        {
            if (tank.isLive())
            {
                draw(g, tank);
                move(tank, missileList);
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
        case LEFT:
            g.drawLine(x1 + x2 - (int) (x2 * Math.sqrt(2)), y1 + y2, x1 + x2,
                    y1 + y2);
            break;
        case UP:
            g.drawLine(x1 + x2, y1 + y2 - (int) (y2 * Math.sqrt(2)), x1 + x2,
                    y1 + y2);
            break;
        case RIGHT:
            g.drawLine(x1 + x2 + (int) (x2 * Math.sqrt(2)), y1 + y2, x1 + x2,
                    y1 + y2);
            break;
        case DOWN:
            g.drawLine(x1 + x2, y1 + y2 + (int) (y2 * Math.sqrt(2)), x1 + x2,
                    y1 + y2);
            break;
        case LEFT_UP:
            g.drawLine(x1, y1, x1 + x2, y1 + y2);
            break;
        case RIGHT_UP:
            g.drawLine(x1 + 2 * x2, y1, x1 + x2, y1 + y2);
            break;
        case RIGHT_DOWN:
            g.drawLine(x1 + 2 * x2, y1 + 2 * y2, x1 + x2, y1 + y2);
            break;
        case LEFT_DOWN:
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
    private static void move(Tank tank, List<Missile> missileList)
    {
        tank.setOldX(tank.getX());
        tank.setOldY(tank.getY());
        switch (tank.getDirection())
        {
        case LEFT:
            if (tank.getX() > tank.getPace())
            {
                tank.setX(tank.getX() - tank.getPace());
            }
            break;
        case UP:
            if (tank.getY() > tank.getPace() + Constants.UP_NUM)
            {
                tank.setY(tank.getY() - tank.getPace());
            }
            break;
        case RIGHT:
            if (tank.getX() < (Constants.BACK_WIDTH - tank.getPace() - tank
                    .getWidth()))
            {
                tank.setX(tank.getX() + tank.getPace());
            }
            break;
        case DOWN:
            if (tank.getY() < (Constants.BACK_HEIGHT - tank.getPace() - tank
                    .getHeight()))
            {
                tank.setY(tank.getY() + tank.getPace());
            }
            break;
        case LEFT_UP:
            if (tank.getX() > tank.getPace())
            {
                tank.setX(tank.getX() - tank.getPace());
            }
            if (tank.getY() > tank.getPace() + Constants.UP_NUM)
            {
                tank.setY(tank.getY() - tank.getPace());
            }
            break;
        case RIGHT_UP:
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
        case RIGHT_DOWN:
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
        case LEFT_DOWN:
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
        // case STOP:
        // break;
        default:
            break;
        }
        // 机器人智能化
        if (tank.isRobot())
        {
            Direction[] dirs = Direction.values();
            if (tank.getStep() == 0)
            {
                tank.setStep(r.nextInt(12) + 3);
                int rn = r.nextInt(dirs.length);
                tank.setDirection(dirs[rn]);
            }
            tank.setStep(tank.getStep() - 1);

            if (r.nextInt(40) > 38)
            {
                fire(tank, missileList);
            }
        }
        tank.setBarrel_direction(tank.getDirection());
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
            tank.setDirection(Direction.LEFT);
        }
        else
            // 上
            if (!tank.isLeft() && tank.isUp() && !tank.isRight()
                    && !tank.isDown())
            {
                tank.setDirection(Direction.UP);
            }
            else
                // 右
                if (!tank.isLeft() && !tank.isUp() && tank.isRight()
                        && !tank.isDown())
                {
                    tank.setDirection(Direction.RIGHT);
                }
                else
                    // 下
                    if (!tank.isLeft() && !tank.isUp() && !tank.isRight()
                            && tank.isDown())
                    {
                        tank.setDirection(Direction.DOWN);
                    }
                    else
                        // 左上
                        if (tank.isLeft() && tank.isUp() && !tank.isRight()
                                && !tank.isDown())
                        {
                            tank.setDirection(Direction.LEFT_UP);
                        }
                        else
                            // 右上
                            if (!tank.isLeft() && tank.isUp() && tank.isRight()
                                    && !tank.isDown())
                            {
                                tank.setDirection(Direction.RIGHT_UP);
                            }
                            else
                                // 右下
                                if (!tank.isLeft() && !tank.isUp()
                                        && tank.isRight() && tank.isDown())
                                {
                                    tank.setDirection(Direction.RIGHT_DOWN);
                                }
                                else
                                    // 左下
                                    if (tank.isLeft() && !tank.isUp()
                                            && !tank.isRight() && tank.isDown())
                                    {
                                        tank.setDirection(Direction.LEFT_DOWN);
                                    }
        // else
        // {
        // tank.setDirection(STOP);
        // }
        // if (tank.getDirection() != STOP)
        // {
        // }
    }

    public static List<Tank> createTank(int index)
    {
        List<Tank> tanks = new ArrayList<Tank>();
        Tank tank = new Tank();
        for (int i = 0; i < index; i++)
        {
            tank = new Tank(100 + (i + 1) * 70, 50 + (i + 1) * 50, Direction
                    .values()[r.nextInt(Direction.values().length)]);
            tanks.add(tank);
        }
        return tanks;
    }

    public static void fire(Tank tank, List<Missile> missileList)
    {
        if (!tank.isLive())
        {
            return;
        }
        Missile missile = new Missile(tank.getX(), tank.getY(), tank
                .getBarrel_direction(), tank.getWidth(), tank.getHeight(), tank
                .isRobot());
        missileList.add(missile);
    }
}