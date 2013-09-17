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
package cn.newtouch.tank15;

import java.awt.Color;
import java.awt.Graphics;
import java.util.List;

/**
 * 
 * 炮弹业务处理类
 * 
 * @author zzHe
 * @version 1.0
 * @since 2012-6-12
 */
public class MissileService
{
    /**
     * 
     * 画炮弹
     * 
     * @since 2012-6-12
     * @author zzHe
     * @param g
     *            画笔
     * @param missileList
     *            炮弹列表
     */
    public void draw(Graphics g, List<Missile> missileList)
    {
        for (Missile missile : missileList)
        {
            if (missile.isLive())
            {
                // 重新填色
                Color c = g.getColor();
                g.setColor(Constants.MISSILE_COLOR);
                // 画实心圆
                g.fillOval(missile.getX(), missile.getY(), missile.getWidth(),
                        missile.getHeight());
                g.setColor(c);
                move(missile);
            }
            else
            {
                missileList.remove(missile);
            }
        }
    }

    /**
     * 
     * 炮弹移动
     * 
     * @since 2012-6-12
     * @author zzHe
     * @param missile
     *            炮弹对象
     */
    private void move(Missile missile)
    {
        if (missile.getX() < 0 || missile.getY() < 0
                || missile.getX() + missile.getWidth() > Constants.BACK_WIDTH
                || missile.getY() + missile.getHeight() > Constants.BACK_HEIGHT)
        {
            missile.setLive(false);
        }
        else
        {
            switch (missile.getDirection())
            {
            case Constants.LEFT:
                missile.setX(missile.getX() - missile.getPace());
                break;
            case Constants.UP:
                missile.setY(missile.getY() - missile.getPace());
                break;
            case Constants.RIGHT:
                missile.setX(missile.getX() + missile.getPace());
                break;
            case Constants.DOWN:
                missile.setY(missile.getY() + missile.getPace());
                break;
            case Constants.LEFT_UP:
                missile.setX(missile.getX() - missile.getPace());
                missile.setY(missile.getY() - missile.getPace());
                break;
            case Constants.RIGHT_UP:
                missile.setY(missile.getY() - missile.getPace());
                missile.setX(missile.getX() + missile.getPace());
                break;
            case Constants.RIGHT_DOWN:
                missile.setX(missile.getX() + missile.getPace());
                missile.setY(missile.getY() + missile.getPace());
                break;
            case Constants.LEFT_DOWN:
                missile.setX(missile.getX() - missile.getPace());
                missile.setY(missile.getY() + missile.getPace());
                break;
            default:
                break;
            }
        }
    }
}
