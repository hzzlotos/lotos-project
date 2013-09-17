package cn.newtouch.Topic.designpattern.factory;

public class OperationDiv extends Operation {

	@Override
	public double getResult() throws MyException2 {
		
		double result = 0;
		if (0 == numberB) {
			
			throw new MyException2();
		}
		result = numberA / numberB;
		
		return result;
	}
}