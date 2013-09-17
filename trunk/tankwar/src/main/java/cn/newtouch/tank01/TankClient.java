package cn.newtouch.tank01;

import java.awt.Frame;

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
		//创建窗口
		setVisible(true);
	}

	public static void main(String[] args) {
		TankClient tc = new TankClient();
		tc.lauchFrame();
	}

}