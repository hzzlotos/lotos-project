package cn.newtouch.Topic.designpattern.factory;

public class OperationMul extends Operation {

	@Override
	public double getResult() {

		double result = 0;
		
		result = numberA * numberB;
		
		return result;
	}
}