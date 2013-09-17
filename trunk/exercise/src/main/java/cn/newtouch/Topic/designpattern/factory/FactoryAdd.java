package cn.newtouch.Topic.designpattern.factory;

public class FactoryAdd implements Factory {

	public Operation CreateOperation() {
		
		return new OperationAdd();
	}
}