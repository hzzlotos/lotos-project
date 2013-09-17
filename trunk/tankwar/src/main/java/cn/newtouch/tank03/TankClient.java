package cn.newtouch.tank03;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankClient extends Frame {
	
	private static final long serialVersionUID = 1L;

	@Override
	public void paint(Graphics g) {
		//重新填色
		Color c = g.getColor();
		g.setColor(Color.RED);
		//画实心圆
		g.fillOval(50, 50, 30, 30);
		g.setColor(c);
	}

	public void lauchFrame() {
		//定位
		this.setLocation(200, 100);
		//大小
		this.setSize(800, 600);
		//背景色
		this.setBackground(Color.GREEN);
		//标题
		this.setTitle("TankWar");
		//添加关闭事件
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		//窗口大小事件的处理
		this.setResizable(false);
		//创建窗口
		setVisible(true);
	}

	public static void main(String[] args) {
		TankClient tc = new TankClient();
		tc.lauchFrame();
	}
}