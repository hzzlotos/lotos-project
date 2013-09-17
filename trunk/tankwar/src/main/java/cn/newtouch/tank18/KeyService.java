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

import java.awt.event.KeyEvent;
import java.util.List;

public class KeyService
{

    public static void keyPressed(KeyEvent e, Tank tank)
    {
        int keyCode = e.getKeyCode();
        switch (keyCode)
        {
        // 创建新的敌人坦克
        case KeyEvent.VK_SHIFT:
            List<Tank> tanks = TankService.createTank(Constants.TANK_NUM);
            tank.tc.getTankList().addAll(tanks);
            break;
        // 打炮弹,定义使用ctrl作为炮弹触发键
        case KeyEvent.VK_CONTROL:
            Missile missile = new Missile(tank.getX(), tank.getY(), tank
                    .getBarrel_direction(), tank.getWidth(), tank.getHeight(),
                    tank.isRobot());
            tank.tc.getMissileList().add(missile);
            break;
        // 左
        case KeyEvent.VK_LEFT:
            tank.setLeft(true);
            break;
        // 上
        case KeyEvent.VK_UP:
            tank.setUp(true);
            break;
        // 右
        case KeyEvent.VK_RIGHT:
            tank.setRight(true);
            break;
        // 下
        case KeyEvent.VK_DOWN:
            tank.setDown(true);
            break;
        default:
            break;
        }
        TankService.changeDirection(tank);
    }

    public static void keyReleased(KeyEvent e, Tank tank)
    {
        int keyCode = e.getKeyCode();
        switch (keyCode)
        {
        // 左
        case KeyEvent.VK_LEFT:
            tank.setLeft(false);
            break;
        // 上
        case KeyEvent.VK_UP:
            tank.setUp(false);
            break;
        // 右
        case KeyEvent.VK_RIGHT:
            tank.setRight(false);
            break;
        // 下
        case KeyEvent.VK_DOWN:
            tank.setDown(false);
            break;
        default:
            break;
        }
        TankService.changeDirection(tank);
    }
}