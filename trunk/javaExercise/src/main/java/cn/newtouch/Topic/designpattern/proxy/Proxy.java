package cn.newtouch.Topic.designpattern.proxy;

public class Proxy implements GiveGift {

	private Pursuit gg;

	public Proxy(Girl mm) {
		
		this.gg = new Pursuit(mm);
	}
	
	public void giveFlowers() {
		
		gg.giveFlowers();
	}
}