package cn.newtouch.Topic.designpattern.easyFactory;

public abstract class Operation {
	
	protected double numberA = 0;
	
	protected double numberB = 0;
	
	public abstract double getResult () throws MyException2;

	public double getNumberA() {
		return numberA;
	}

	public void setNumberA(double numberA) {
		this.numberA = numberA;
	}

	public double getNumberB() {
		return numberB;
	}

	public void setNumberB(double numberB) {
		this.numberB = numberB;
	}
}