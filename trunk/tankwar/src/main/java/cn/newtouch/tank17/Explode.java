package cn.newtouch.tank17;

/**
 * 
 * 坦克爆炸图形
 * 
 * @author zzHe
 * @version 1.0
 * @since 2012-6-13
 */
public class Explode extends BaseObject
{
    private int[] diameter = { 4, 7, 12, 18, 26, 32, 49, 30, 14, 6 };

    private int   step     = 0;

    public int[] getDiameter()
    {
        return diameter;
    }

    public void setDiameter(int[] diameter)
    {
        this.diameter = diameter;
    }

    public int getStep()
    {
        return step;
    }

    public void setStep(int step)
    {
        this.step = step;
    }

    /**
     * 
     * 根据坦克模型对爆炸初始化
     * 
     * @since 2012-6-13
     * @param tankX
     *            坦克X
     * @param tankY
     *            坦克Y
     * @param tankWidth
     *            坦克宽度
     * @param tankHeight
     *            坦克高度
     */
    public Explode(int tankX, int tankY)
    {
        this.color = Constants.EXPLODE_COLOR;
        x = tankX;
        y = tankY;
    }
}