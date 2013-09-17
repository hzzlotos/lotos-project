package cn.newtouch.tank21;

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

    private List<Tank>        tankList         = new ArrayList<Tank>();

    private List<Missile>     missileList      = new ArrayList<Missile>();

    private List<Explode>     explodeList      = new ArrayList<Explode>();

    private Tank              mytank;

    private Thread            thread;

    public List<Tank> getTankList()
    {
        return tankList;
    }

    public void setTankList(List<Tank> tankList)
    {
        this.tankList = tankList;
    }

    public List<Missile> getMissileList()
    {
        return missileList;
    }

    public void setMissileList(List<Missile> missileList)
    {
        this.missileList = missileList;
    }

    public List<Explode> getExplodeList()
    {
        return explodeList;
    }

    public void setExplodeList(List<Explode> explodeList)
    {
        this.explodeList = explodeList;
    }

    public TankClient()
    {
        mytank = new Tank(Constants.TANK_COLOR);
        tankList.add(mytank);
        List<Tank> tanks = TankService.createTank(Constants.TANK_NUM);
        tankList.addAll(tanks);
    }

    @Override
    public void paint(Graphics g)
    {
        if (!tankList.get(0).isLive())
        {
            g.drawString("game over!", 10, 50);
        }
        RemoveService.remove(tankList, missileList, explodeList);
        HitService.hit(tankList, missileList, explodeList);
        TankService.draw(g, tankList, missileList);
        MissileService.draw(g, missileList);
        ExplodeService.explode(g, explodeList);
        // g.drawString("tankList    count:" + tankList.size(), 10, 50);
        // g.drawString("missiles    count:" + missileList.size(), 30, 70);
        // g.drawString("explodeList count:" + explodeList.size(), 50, 90);
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

        thread = new Thread(new PaintThread());
        thread.start();
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
            if (g.getKeyCode() == KeyEvent.VK_SPACE)
            {
                tankList = new ArrayList<Tank>();
                mytank = new Tank(Constants.TANK_COLOR);
                tankList.add(mytank);
                List<Tank> tanks = TankService.createTank(Constants.TANK_NUM);
                tankList.addAll(tanks);
                missileList = new ArrayList<Missile>();
                explodeList = new ArrayList<Explode>();
            }
            else
            {
                KeyService.keyPressed(g, mytank, tankList, missileList);
            }
        }

        @Override
        public void keyReleased(KeyEvent e)
        {
            KeyService.keyReleased(e, mytank);
        }
    }
}