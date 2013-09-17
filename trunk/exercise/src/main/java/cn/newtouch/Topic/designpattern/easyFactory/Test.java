package cn.newtouch.Topic.designpattern.easyFactory;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		
		double first = 0;
		double second = 0;
		// input
		Scanner scanner = new Scanner(System.in);
		String in = "";
		Operation oper = null;
		boolean flag = true;
		
		while (flag) {
		
			try {
				System.out.println("Please! Input a number!");
				// input
				in = scanner.nextLine();
				//checknumber
				//CheckNumber.checkNum(in);
				first = Double.parseDouble(in);
				System.out.println("Please! Input other number!");
				in = scanner.nextLine();
			    //CheckNumber.checkNum(in);
		    	second = Double.parseDouble(in);
		    	System.out.println("Please! Input the operator!");
		        in = scanner.nextLine();
				oper = OperationFactory.createOperation(in);
				oper.numberA = first;
				oper.setNumberB(second);
				System.out.println(oper.getResult());
			} catch (MyException e) {
				//e.printStackTrace();
				System.out.println("Please! Input a right operator!");
			} catch (NumberFormatException e1) {
				//e1.printStackTrace();
				System.out.println("Please! Input a right number!");
			} catch (MyException2 e2) {
				//e2.printStackTrace();
				System.out.println("Divisor can not be zero!");
			} 
			System.out.println("Do you use again? Yes is \"Y\", No is the other!");
			in = scanner.nextLine();
			if (null == in || !("Y".equals(in) || "y".equals(in))) {
				flag = false;
				System.out.println("Procedure has been closed!");
			}
		}
	}
}