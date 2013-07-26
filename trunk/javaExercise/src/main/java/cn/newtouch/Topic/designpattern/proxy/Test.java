package cn.newtouch.Topic.designpattern.proxy;

public class Test {

	public static void main(String[] args) {
		
		Girl mm = new Girl("baobei");
		
		Proxy proxy = new Proxy(mm);
		
		proxy.giveFlowers();
	}
}