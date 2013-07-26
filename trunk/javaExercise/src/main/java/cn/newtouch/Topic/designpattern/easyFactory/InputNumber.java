package cn.newtouch.Topic.designpattern.easyFactory;

import java.util.Scanner;

public class InputNumber {

	public static double inputNum() throws NumberFormatException { 

		double doubleNum = 0;
		
		System.out.println("Please! Input a number!");
		
		Scanner scanner = new Scanner(System.in);
		
		String in = scanner.nextLine();
		
		doubleNum = Double.parseDouble(in);
		
		return doubleNum;
	}
}