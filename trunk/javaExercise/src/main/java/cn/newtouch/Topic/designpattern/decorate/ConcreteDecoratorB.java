package cn.newtouch.Topic.designpattern.decorate;

public class ConcreteDecoratorB extends Decorator {

	public void operation() {
		super.operation();
		AddedBehavior();
		System.out.println("ConcreteDecoratorB");
	}
	
	private void AddedBehavior(){
		
	}
}
