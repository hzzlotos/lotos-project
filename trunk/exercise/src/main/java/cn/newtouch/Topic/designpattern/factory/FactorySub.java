package cn.newtouch.Topic.designpattern.factory;

public class FactorySub implements Factory {

	public Operation CreateOperation() {
		
		return new OperationSub();
	}
}