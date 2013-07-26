package cn.newtouch.Topic.designpattern.easyFactory;

public class OperationFactory {

	public static Operation createOperation(String operate) throws MyException{
		
		Operation oper = null;
		
		if ("+".equals(operate)) {
			
			oper = new OperationAdd();
			
		} else if ("-".equals(operate)) {
			
			oper = new OperationSub();
			
		} else if ("*".equals(operate)) {
			
			oper = new OperationMul();
			
		} else if ("/".equals(operate)) {
			
			oper = new OperationDiv();
			
		} else {
			
			throw new MyException();
		}
		
		return oper;
	}
}