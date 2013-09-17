package cn.newtouch.tank12and13;

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
    private int x;

    // 炮弹定位Y,默认值为23
    private int y;

    // 炮弹宽度,默认值为30
    private int width     = 10;

    // 炮弹高度,默认值为30
    private int height    = 10;

    // 炮弹的方向,默认值为停止
    private int direction = Constants.STOP;

    // 炮弹的步伐,默认值为5
    private int pace      = 10;

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
        x = tankX + tankWidth / 2 - width / 2;
        // 炮弹高度等同于宽度设置
        y = tankY + tankHeight / 2 - height / 2;
        direction = tankDirection;
    }

    public Missile()
    {
    }

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

    public int getDirection()
    {
        return direction;
    }

    public void setDirection(int direction)
    {
        this.direction = direction;
    }

    public int getPace()
    {
        return pace;
    }

    public void setPace(int pace)
    {
        this.pace = pace;
    }
}