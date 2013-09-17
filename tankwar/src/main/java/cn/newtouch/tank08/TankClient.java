package cn.newtouch.tank08;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

public class TankClient extends Frame
{

    private static final long serialVersionUID = 1L;

    private Image             offScreenImage   = null;

    private TankService       tankService      = new TankService();

    private List<Tank>        tankList         = new ArrayList<Tank>();

    private Tank              mytank           = new Tank();

    public TankClient()
    {
        tankService = new TankService();
        mytank = new Tank();
        tankList.add(mytank);
        Tank tank = new Tank();
        tank.setTank_x(50);
        tank.setTank_y(50);
        tank.setTank_color(Color.YELLOW);
        tankList.add(tank);
        tank = new Tank();
        tank.setTank_x(100);
        tank.setTank_y(100);
        tank.setTank_color(Color.YELLOW);
        tankList.add(tank);
    }

    @Override
    public void paint(Graphics g)
    {
        tankService.draw(g, tankList);
    }

    @Override
    public void update(Graphics g)
    {
        if (offScreenImage == null)
        {
            offScreenImage = this.createImage(Constants.BACK_WIDTH,
                    Constants.BACK_HEIGHT);
        }
        // 取得画板上的画笔
        Graphics gOffScreen = offScreenImage.getGraphics();
        Color c = gOffScreen.getColor();
        gOffScreen.setColor(Constants.BACK_COLOR);
        // 花一个方块出来盖住前一个图片
        gOffScreen.fillRect(Constants.DEFAULT_NUM, Constants.DEFAULT_NUM,
                Constants.BACK_WIDTH, Constants.BACK_HEIGHT);
        gOffScreen.setColor(c);
        paint(gOffScreen);
        // 屏幕上画出画面
        g.drawImage(offScreenImage, Constants.DEFAULT_NUM,
                Constants.DEFAULT_NUM, null);
    }

    public void lauchFrame()
    {
        // 定位
        this.setLocation(Constants.BACK_X, Constants.BACK_Y);
        // 大小
        this.setSize(Constants.BACK_WIDTH, Constants.BACK_HEIGHT);
        // 背景色
        this.setBackground(Constants.BACK_COLOR);
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

        // 创建键盘监听器
        this.addKeyListener(new KeyMonitor());
        // 创建窗口
        setVisible(true);

        new Thread(new PaintThread()).start();
    }

    public static void main(String[] args)
    {
        TankClient tc = new TankClient();
        tc.lauchFrame();
    }

    // 内部线程类
    private class PaintThread implements Runnable
    {
        public void run()
        {
            while (true)
            {
                repaint();
                try
                {
                    Thread.sleep(100);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }

    private class KeyMonitor extends KeyAdapter
    {
        @Override
        public void keyPressed(KeyEvent g)
        {
            tankService.keyPressed(g, mytank);
        }
    }

}