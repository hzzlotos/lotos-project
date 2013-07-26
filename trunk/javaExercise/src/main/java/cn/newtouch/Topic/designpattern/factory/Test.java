package cn.newtouch.Topic.designpattern.factory;

public class Test {

	public static void main(String[] args) {
		
		Factory of = new FactoryAdd();
		
		Operation op  = of.CreateOperation();
		
		op.setNumberA(123D);
		op.setNumberB(456D);
		
		try {
			System.out.println(op.getResult());
		} catch (MyException2 e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}