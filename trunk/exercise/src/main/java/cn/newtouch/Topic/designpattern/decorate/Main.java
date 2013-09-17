package cn.newtouch.Topic.designpattern.decorate;

public class Main {

	public static void main(String[] args) {
		ConcreteComponent c = new ConcreteComponent();
		ConcreteDecoratorA c1 = new ConcreteDecoratorA();
		ConcreteDecoratorB c2 = new ConcreteDecoratorB();
		
		c1.setComponent(c);
		c2.setComponent(c1);
		c2.operation();
	}
}