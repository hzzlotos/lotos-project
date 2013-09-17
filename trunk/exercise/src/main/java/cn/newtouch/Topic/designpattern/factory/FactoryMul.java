package cn.newtouch.Topic.designpattern.factory;

public class FactoryMul implements Factory {

	public Operation CreateOperation() {
		
		return new OperationMul();
	}
}