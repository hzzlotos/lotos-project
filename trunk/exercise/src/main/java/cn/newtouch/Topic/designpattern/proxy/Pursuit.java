package cn.newtouch.Topic.designpattern.proxy;

public class Pursuit implements GiveGift {

	private Girl mm;
	
	public Pursuit (Girl mm) {
		
		this.mm = mm;
	}
	
	public void giveFlowers() {
		
		System.out.println(mm.getname()+", give you flowers!");
	}
}
