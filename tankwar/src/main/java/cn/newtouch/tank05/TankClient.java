package cn.newtouch.tank05;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankClient extends Frame
{

    private static final long serialVersionUID = 1L;

    private int               tank_x           = 50;  // 坦克定位X

    int                       tank_y           = 50;  // 坦克定位Y

    private static final int  TANK_WIDTH       = 30;  // 坦克宽度

    private static final int  TANK_HEIGHT      = 30;  // 坦克高度

    private static final int  BACK_X           = 200; // 定位X

    private static final int  BACK_Y           = 100; // 定位Y

    private static final int  BACK_WIDTH       = 800; // 背景宽度

    private static final int  BACK_HEIGHT      = 600; // 背景高度

    Image                     offScreenImage   = null;

    @Override
    public void paint(Graphics g)
    {
        // 重新填色
        Color c = g.getColor();
        g.setColor(Color.RED);
        // 画实心圆
        g.fillOval(tank_x, tank_y, TANK_WIDTH, TANK_HEIGHT);
        g.setColor(c);
    }

    @Override
    public void update(Graphics g)
    {
        if (offScreenImage == null)
        {
            offScreenImage = this.createImage(BACK_WIDTH, BACK_HEIGHT);
        }
        // 取得画板上的画笔
        Graphics gOffScreen = offScreenImage.getGraphics();
        Color c = gOffScreen.getColor();
        gOffScreen.setColor(Color.GREEN);
        // 花一个方块出来盖住前一个图片
        gOffScreen.fillRect(0, 0, BACK_WIDTH, BACK_HEIGHT);
        gOffScreen.setColor(c);
        paint(gOffScreen);
        // 屏幕上画出画面
        g.drawImage(offScreenImage, 0, 0, null);
    }

    public void lauchFrame()
    {
        // 定位
        this.setLocation(BACK_X, BACK_Y);
        // 大小
        this.setSize(BACK_WIDTH, BACK_HEIGHT);
        // 背景色
        this.setBackground(Color.GREEN);
        // 标题
        this.setTitle("TankWar");
        // 添加关闭事件
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e)
            {
                System.exit(0);
            }
        });
        // 窗口大小事件的处理
        this.setResizable(false);
        // 创建窗口
        setVisible(true);

        new Thread(new PaintThread()).start();
    }

    public static void main(String[] args)
    {
        TankClient tc = new TankClient();
        tc.lauchFrame();
    }

    private class PaintThread implements Runnable
    {

        public void run()
        {
            while (true)
            {
                repaint();
                tank_y += 5;
                try
                {
                    Thread.sleep(10);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        }

    }
}