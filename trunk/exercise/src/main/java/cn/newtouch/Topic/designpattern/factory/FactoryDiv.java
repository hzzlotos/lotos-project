package cn.newtouch.Topic.designpattern.factory;

public class FactoryDiv implements Factory {

	public Operation CreateOperation() {
		
		return new OperationDiv();
	}

}
