package cn.newtouch.tank02;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankClient extends Frame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void lauchFrame() {
		//定位
		this.setLocation(200, 100);
		//大小
		this.setSize(800, 600);
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