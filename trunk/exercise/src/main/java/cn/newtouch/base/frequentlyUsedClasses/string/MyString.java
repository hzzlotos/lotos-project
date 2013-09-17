package cn.newtouch.base.frequentlyUsedClasses.string;

public class MyString {
	
	//String.concat();
	
	public static String addString (String strFormat, String str) {
		
		StringBuffer sb = new StringBuffer();
		
		sb.append(strFormat);
		
		sb.append(str);
		
		String result = sb.toString();
		
		return result;
	}
	
	public static void main (String[] args) {
		
		String str = "342asdf23asd";
		
		String.format("", str);
		
		System.out.println(str);
		
		String aaa = str.concat("=====");
		
		System.out.println(aaa);
		
		System.out.println(str.contains("asd"));
		
		System.out.println(str.substring(1));
		
		System.out.println(str.substring(2,5));
		
		System.out.println(str.replace("asd", "zxc"));
		
		System.out.println(str.replaceAll("asd", "zxc"));
	}
}