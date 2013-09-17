package cn.newtouch.Topic.designpattern.decorate;

public class ConcreteDecoratorA extends Decorator {

	private String addedState;

	public String getAddedState() {
		return addedState;
	}
	
	public void setAddedState(String addedState) {
		this.addedState = addedState;
	}

	public void operation() {
		super.operation();
		addedState = "New State";
		System.out.println("ConcreteDecoratorA");
	}
}