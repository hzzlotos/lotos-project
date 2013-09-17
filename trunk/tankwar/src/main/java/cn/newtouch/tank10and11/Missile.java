package cn.newtouch.tank10and11;

import java.awt.Color;

/**
 * 
 * 炮弹对象类
 * 
 * @author zzHe
 * @version 1.0
 * @since 2012-6-13
 */
public class Missile
{

    // 炮弹定位X,默认值为5
    private int   missile_x;

    // 炮弹定位Y,默认值为23
    private int   missile_y;

    // 炮弹宽度,默认值为30
    private int   missile_width     = 10;

    // 炮弹高度,默认值为30
    private int   missile_height    = 10;

    // 炮弹颜色,默认值为红色
    private Color missile_color     = Color.BLACK;

    // 炮弹的方向,默认值为停止
    private int   missile_direction = Constants.STOP;

    // 炮弹的步伐,默认值为5
    private int   missile_pace      = 10;

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
     */
    public Missile(int tankX, int tankY, int tankDirection, int tankWidth,
            int tankHeight)
    {
        // 炮弹的X位置是由坦克的X+坦克宽度的二分之一再向前缩进炮弹自身的宽度的二分之一
        missile_x = tankX + tankWidth / 2 - missile_width / 2;
        // 炮弹高度等同于宽度设置
        missile_y = tankY + tankHeight / 2 - missile_height / 2;
        missile_direction = tankDirection;
    }

    public Missile()
    {
    }

    /**
     * 
     * 炮弹初始化
     * 
     * @since 2012-6-13
     * @param missileX
     *            炮弹X
     * @param missileY
     *            炮弹Y
     * @param missileWidth
     *            炮弹宽度
     * @param missileHeight
     *            炮弹高度
     * @param missileColor
     *            炮弹颜色
     * @param missileDirection
     *            炮弹方向
     * @param missilePace
     *            炮弹频率
     */
    public Missile(int missileX, int missileY, int missileWidth,
            int missileHeight, Color missileColor, int missileDirection,
            int missilePace)
    {
        missile_x = missileX;
        missile_y = missileY;
        missile_width = missileWidth;
        missile_height = missileHeight;
        missile_color = missileColor;
        missile_direction = missileDirection;
        missile_pace = missilePace;
    }

    public int getMissile_x()
    {
        return missile_x;
    }

    public void setMissile_x(int missileX)
    {
        missile_x = missileX;
    }

    public int getMissile_y()
    {
        return missile_y;
    }

    public void setMissile_y(int missileY)
    {
        missile_y = missileY;
    }

    public int getMissile_width()
    {
        return missile_width;
    }

    public void setMissile_width(int missileWidth)
    {
        missile_width = missileWidth;
    }

    public int getMissile_height()
    {
        return missile_height;
    }

    public void setMissile_height(int missileHeight)
    {
        missile_height = missileHeight;
    }

    public Color getMissile_color()
    {
        return missile_color;
    }

    public void setMissile_color(Color missileColor)
    {
        missile_color = missileColor;
    }

    public int getMissile_direction()
    {
        return missile_direction;
    }

    public void setMissile_direction(int missileDirection)
    {
        missile_direction = missileDirection;
    }

    public int getMissile_pace()
    {
        return missile_pace;
    }

    public void setMissile_pace(int missilePace)
    {
        missile_pace = missilePace;
    }
}