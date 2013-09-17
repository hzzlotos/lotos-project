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
package cn.newtouch.tank10and11;

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
    public void draw(Graphics g, List<Tank> tankList)
    {
        for (Tank tank : tankList)
        {
            // 重新填色
            Color c = g.getColor();
            g.setColor(tank.getTank_color());
            // 画方块
            g.fillRect(tank.getTank_x(), tank.getTank_y(),
                    tank.getTank_width(), tank.getTank_height());
            g.setColor(c);
            move(tank);
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
    private void move(Tank tank)
    {
        switch (tank.getTank_direction())
        {
        case Constants.LEFT:
            if (tank.getTank_x() >= tank.getTank_pace())
            {
                tank.setTank_x(tank.getTank_x() - tank.getTank_pace());
            }
            break;
        case Constants.UP:
            if (tank.getTank_y() >= tank.getTank_pace() + Constants.UP_NUM)
            {
                tank.setTank_y(tank.getTank_y() - tank.getTank_pace());
            }
            break;
        case Constants.RIGHT:
            if (tank.getTank_x() <= (Constants.BACK_WIDTH - tank.getTank_pace()))
            {
                tank.setTank_x(tank.getTank_x() + tank.getTank_pace());
            }
            break;
        case Constants.DOWN:
            if (tank.getTank_y() <= (Constants.BACK_HEIGHT - tank
                    .getTank_pace()))
            {
                tank.setTank_y(tank.getTank_y() + tank.getTank_pace());
            }
            break;
        case Constants.LEFT_UP:
            if (tank.getTank_x() >= tank.getTank_pace())
            {
                tank.setTank_x(tank.getTank_x() - tank.getTank_pace());
            }
            if (tank.getTank_y() >= tank.getTank_pace() + Constants.UP_NUM)
            {
                tank.setTank_y(tank.getTank_y() - tank.getTank_pace());
            }
            break;
        case Constants.RIGHT_UP:
            if (tank.getTank_y() >= tank.getTank_pace() + Constants.UP_NUM)
            {
                tank.setTank_y(tank.getTank_y() - tank.getTank_pace());
            }
            if (tank.getTank_x() <= (Constants.BACK_WIDTH - tank.getTank_pace()))
            {
                tank.setTank_x(tank.getTank_x() + tank.getTank_pace());
            }
            break;
        case Constants.RIGHT_DOWN:
            if (tank.getTank_x() <= (Constants.BACK_WIDTH - tank.getTank_pace()))
            {
                tank.setTank_x(tank.getTank_x() + tank.getTank_pace());
            }
            if (tank.getTank_y() <= (Constants.BACK_HEIGHT - tank
                    .getTank_pace()))
            {
                tank.setTank_y(tank.getTank_y() + tank.getTank_pace());
            }
            break;
        case Constants.LEFT_DOWN:
            if (tank.getTank_x() >= tank.getTank_pace())
            {
                tank.setTank_x(tank.getTank_x() - tank.getTank_pace());
            }
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

    /**
     * 
     * 坦克移动
     * 
     * @since 2012-6-12
     * @author zzHe
     * @param tank
     *            坦克
     */
    private void changeDirection(Tank tank)
    {
        // 左
        if (tank.isTank_isleft() && !tank.isTank_isup()
                && !tank.isTank_isright() && !tank.isTank_isdown())
        {
            tank.setTank_direction(Constants.LEFT);
        }
        else
            // 上
            if (!tank.isTank_isleft() && tank.isTank_isup()
                    && !tank.isTank_isright() && !tank.isTank_isdown())
            {
                tank.setTank_direction(Constants.UP);
            }
            else
                // 右
                if (!tank.isTank_isleft() && !tank.isTank_isup()
                        && tank.isTank_isright() && !tank.isTank_isdown())
                {
                    tank.setTank_direction(Constants.RIGHT);
                }
                else
                    // 下
                    if (!tank.isTank_isleft() && !tank.isTank_isup()
                            && !tank.isTank_isright() && tank.isTank_isdown())
                    {
                        tank.setTank_direction(Constants.DOWN);
                    }
                    else
                        // 左上
                        if (tank.isTank_isleft() && tank.isTank_isup()
                                && !tank.isTank_isright()
                                && !tank.isTank_isdown())
                        {
                            tank.setTank_direction(Constants.LEFT_UP);
                        }
                        else
                            // 右上
                            if (!tank.isTank_isleft() && tank.isTank_isup()
                                    && tank.isTank_isright()
                                    && !tank.isTank_isdown())
                            {
                                tank.setTank_direction(Constants.RIGHT_UP);
                            }
                            else
                                // 右下
                                if (!tank.isTank_isleft()
                                        && !tank.isTank_isup()
                                        && tank.isTank_isright()
                                        && tank.isTank_isdown())
                                {
                                    tank
                                            .setTank_direction(Constants.RIGHT_DOWN);
                                }
                                else
                                    // 左下
                                    if (tank.isTank_isleft()
                                            && !tank.isTank_isup()
                                            && !tank.isTank_isright()
                                            && tank.isTank_isdown())
                                    {
                                        tank
                                                .setTank_direction(Constants.LEFT_DOWN);
                                    }
    }

    /**
     * 
     * 根据键盘按键判断坦克的动作
     * 
     * @since 2012-6-12
     * @author zzHe
     * @param e
     *            键盘event
     * @param tank
     *            坦克
     * @param missileList
     *            炮弹列表
     * @return missileList 返回炮弹列表以供client处理
     */

    public List<Missile> keyPressed(KeyEvent e, Tank tank,
            List<Missile> missileList)
    {
        int keyCode = e.getKeyCode();
        switch (keyCode)
        {
        // 打炮弹,定义使用ctrl作为炮弹触发键
        case KeyEvent.VK_CONTROL:
            Missile missile = new Missile(tank.getTank_x(), tank.getTank_y(),
                    tank.getTank_direction(), tank.getTank_width(), tank
                            .getTank_height());
            missileList.add(missile);
            break;
        // 左
        case KeyEvent.VK_LEFT:
            tank.setTank_isleft(true);
            break;
        // 上
        case KeyEvent.VK_UP:
            tank.setTank_isup(true);
            break;
        // 右
        case KeyEvent.VK_RIGHT:
            tank.setTank_isright(true);
            break;
        // 下
        case KeyEvent.VK_DOWN:
            tank.setTank_isdown(true);
            break;
        default:
            break;
        }
        changeDirection(tank);
        return missileList;
    }

    /**
     * 
     * 根据键盘抬起重置坦克方向
     * 
     * @since 2012-6-12
     * @author zzHe
     * @param e
     *            键盘操作event
     * @param tank
     *            所操作的坦克
     */
    public void keyReleased(KeyEvent e, Tank tank)
    {
        int keyCode = e.getKeyCode();
        switch (keyCode)
        {
        // 左
        case KeyEvent.VK_LEFT:
            tank.setTank_isleft(false);
            break;
        // 上
        case KeyEvent.VK_UP:
            tank.setTank_isup(false);
            break;
        // 右
        case KeyEvent.VK_RIGHT:
            tank.setTank_isright(false);
            break;
        // 下
        case KeyEvent.VK_DOWN:
            tank.setTank_isdown(false);
            break;
        default:
            break;
        }
        changeDirection(tank);
    }
}