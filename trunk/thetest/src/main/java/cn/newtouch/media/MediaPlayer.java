package cn.newtouch.media;

import java.awt.BorderLayout;
import java.awt.CheckboxMenuItem;
import java.awt.Color;
import java.awt.Component;
import java.awt.FileDialog;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.media.ControllerClosedEvent;
import javax.media.ControllerEvent;
import javax.media.ControllerListener;
import javax.media.EndOfMediaEvent;
import javax.media.Manager;
import javax.media.MediaLocator;
import javax.media.NoPlayerException;
import javax.media.Player;
import javax.media.PrefetchCompleteEvent;
import javax.media.RealizeCompleteEvent;
import javax.media.Time;

public class MediaPlayer extends Frame implements ActionListener, ControllerListener, ItemListener

{

    Player player;

    Component vc, cc;

    boolean   first = true, loop = false;

    String    currentDirectory;

    MediaPlayer(String title)

    {

        super(title);

        this.addWindowListener

        (new WindowAdapter()

        {

            @Override
            public void windowClosing(WindowEvent e)

            {

                // 用户点击窗口系统菜单的关闭按钮

                // 调用dispose以执行windowClosed

                MediaPlayer.this.dispose();

            }

            @Override
            public void windowClosed(WindowEvent e)
            {

                if (MediaPlayer.this.player != null)
                {
                    MediaPlayer.this.player.close();
                }

                System.exit(0);

            }

        });

        Menu m = new Menu("wenjian");

        MenuItem mi = new MenuItem("dakai");

        mi.addActionListener(this);

        m.add(mi);

        m.addSeparator();

        CheckboxMenuItem cbmi = new CheckboxMenuItem("xunhuan", false);

        cbmi.addItemListener(this);

        m.add(cbmi);

        m.addSeparator();

        mi = new MenuItem("tuichu");

        mi.addActionListener(this);

        m.add(mi);

        MenuBar mb = new MenuBar();

        mb.add(m);

        this.setMenuBar(mb);

        this.setSize(200, 200);

        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e)

    {

        if (e.getActionCommand().equals("tuichu"))

        {

            // 调用dispose以便执行windowClosed

            this.dispose();

            return;

        }

        FileDialog fd = new FileDialog(this, "dakaiwenjian",

        FileDialog.LOAD);

        fd.setDirectory(this.currentDirectory);

        fd.show();

        // 如果用户放弃选择文件，则返回

        if (fd.getFile() == null)
        {
            return;
        }

        this.currentDirectory = fd.getDirectory();

        if (this.player != null)
        {
            this.player.close();
        }

        try

        {

            this.player = Manager.createPlayer(new MediaLocator

            ("file:" + fd.getDirectory() + fd.getFile()));

        }

        catch (java.io.IOException e2)

        {

            System.out.println(e2);

            return;

        }

        catch (NoPlayerException e2)

        {

            System.out.println("不能找到播放器.");

            return;

        }

        if (this.player == null)

        {

            System.out.println("无法创建播放器.");

            return;

        }

        this.first = false;

        this.setTitle(fd.getFile());

        this.player.addControllerListener(this);

        this.player.prefetch();

    }

    @Override
    public void controllerUpdate(ControllerEvent e)

    {

        // 调用player.close()时ControllerClosedEvent事件出现。

        // 如果存在视觉部件，则该部件应该拆除（为一致起见，

        // 我们对控制面板部件也执行同样的操作）

        if (e instanceof ControllerClosedEvent)

        {

            if (this.vc != null)

            {

                this.remove(this.vc);

                this.vc = null;

            }

            if (this.cc != null)

            {

                this.remove(this.cc);

                this.cc = null;

            }

            return;

        }

        if (e instanceof EndOfMediaEvent)

        {

            if (this.loop)

            {

                this.player.setMediaTime(new Time(0));

                this.player.start();

            }

            return;

        }

        if (e instanceof PrefetchCompleteEvent)

        {

            this.player.start();

            return;

        }

        if (e instanceof RealizeCompleteEvent)

        {

            this.vc = this.player.getVisualComponent();

            if (this.vc != null)
            {
                this.add(this.vc);
            }

            this.cc = this.player.getControlPanelComponent();

            if (this.cc != null)
            {
                this.add(this.cc, BorderLayout.SOUTH);
            }

            this.pack();

        }

    }

    @Override
    public void itemStateChanged(ItemEvent e)

    {

        this.loop = !this.loop;

    }

    @Override
    public void paint(Graphics g)

    {

        if (this.first)

        {

            int w = this.getSize().width;

            int h = this.getSize().height;

            g.setColor(Color.blue);

            g.fillRect(0, 0, w, h);

            Font f = new Font("DialogInput", Font.BOLD, 16);

            g.setFont(f);

            FontMetrics fm = g.getFontMetrics();

            int swidth = fm.stringWidth("*** 欢迎 ***");

            g.setColor(Color.white);

            g.drawString("*** 欢迎 ***",

            (w - swidth) / 2,

            (h + this.getInsets().top) / 2);
        }

        // 调用超类Frame的paint()方法，该paint()方法将调用Frame包含的各个容器

        // 和部件（包括控制面板部件）的paint()方法。

        super.paint(g);

    }

    // 不执行背景清除操作，以免控制面板部件闪烁

    @Override
    public void update(Graphics g)

    {

        this.paint(g);

    }

    public static void main(String[] args)

    {

        new MediaPlayer("媒体播放器1.0");

    }

}
