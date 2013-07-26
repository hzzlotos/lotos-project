package cn.newtouch.Topic.designpattern.easyFactory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckNumber {

	public static void checkNum(String str) throws MyException {
		
		Pattern p=Pattern.compile("^[0-9]*[.][0-9]*|^[0-9]*");
		
		Matcher m=p.matcher(str); 
		
		boolean bool = true;
		
		bool = m.matches();
		
		if (bool) {
			
			throw new MyException();
		}
	}
}