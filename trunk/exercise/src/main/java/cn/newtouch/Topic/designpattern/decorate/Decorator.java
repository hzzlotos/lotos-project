package cn.newtouch.Topic.designpattern.decorate;

public abstract class Decorator implements Component {

	protected Component component;

	public Component getComponent() {
		return component;
	}

	public void setComponent(Component component) {
		this.component = component;
	}

	public void operation() {
		if (null != component) {
			
			component.operation();
		}
	}
}
