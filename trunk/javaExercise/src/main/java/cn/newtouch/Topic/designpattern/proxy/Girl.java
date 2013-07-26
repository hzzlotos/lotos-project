package cn.newtouch.Topic.designpattern.proxy;

public class Girl implements GiveGift {

	private String name;
	
	public Girl (String name) {
		
		this.name = name;
	}
	
	public void giveFlowers() {
		
	}

	public String getname() {
		
		return this.name;
	}
}