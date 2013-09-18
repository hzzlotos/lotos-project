package cn.newtouch.junit;

import junit.framework.TestCase;

public class MyJunit extends TestCase {

	public MyJunit(String name) {
		super(name);
	}

	public void testSay() {
		
		HelloWorld hi = new HelloWorld();
		
		assertEquals("Hello World!", hi.say());
	}
	/*
	public static void main(String[] args) {

		junit.textui.TestRunner.run(MyJunit.class);
	}*/
}