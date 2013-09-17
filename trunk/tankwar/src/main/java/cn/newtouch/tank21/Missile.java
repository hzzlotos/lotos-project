package cn.newtouch.tank21;

import cn.newtouch.tank19.Constants.Direction;

/**
 * 
 * 炮弹对象类
 * 
 * @author zzHe
 * @version 1.0
 * @since 2012-6-13
 */
public class Missile extends BaseObject
{

    /**
     * 
     * 根据坦克模型对炮弹初始化
     * 
     * @since 2012-6-13
     * @param tankX
     *            坦克X
     * @param tankY
     *            坦克Y
     * @param tankDirection
     *            坦克方向
     * @param tankWidth
     *            坦克宽度
     * @param tankHeight
     *            坦克高度
     * @param robot
     *            是否为机器人的子弹
     */
    public Missile(int tankX, int tankY, Direction tankDirection,
            int tankWidth, int tankHeight, boolean robot)
    {
        this.width = 10;
        this.height = 10;
        this.pace = 10;
        if (!robot)
        {
            this.color = Constants.MISSILE_COLOR;
        }
        else
        {
            this.color = Constants.MISSILE_COLOR_OTHER;
        }
        // 炮弹的X位置是由坦克的X+坦克宽度的二分之一再向前缩进炮弹自身的宽度的二分之一
        x = tankX + tankWidth / 2 - width / 2;
        // 炮弹高度等同于宽度设置
        y = tankY + tankHeight / 2 - height / 2;
        direction = tankDirection;
        this.robot = robot;
    }

    /**
     * 
     * 默认
     * 
     * @since 2012-6-14
     */
    public Missile()
    {
        this.x = 0;
        this.y = 0;
        this.width = 10;
        this.height = 10;
        this.color = Constants.MISSILE_COLOR;
        this.direction = Direction.LEFT;
        this.pace = 10;
        this.live = true;
        this.robot = true;
    }
}