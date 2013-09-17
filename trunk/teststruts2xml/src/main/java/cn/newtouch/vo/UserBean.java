package cn.newtouch.vo;

import java.util.Date;

public class UserBean {

	private String userName;
	
	private String passWord;
	
	private int age;
	
	private Date birth;
	
	public UserBean() {}
	
	public UserBean(String userName, String passWord, int age, Date birth) {
		
		this.userName = userName;
		
		this.passWord = passWord;
		
		this.age = age;
		
		this.birth = birth;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}
}