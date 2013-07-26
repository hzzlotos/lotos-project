package cn.newtouch.base.container.collection.simple;

public class Human {

	public Human (String name, int age, String sex) {

		this.name = name;

		this.age = age;

		this.sex = sex;
	}

	private String name = "";

	private int age = 0;

	private String sex = "";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Boolean equals(Human man) {

		if (name.equals(man.getName()) && sex.equals(man.getSex()) && ( age == man.getAge())) {

			return true;

		} else {

			return false;
		}
	}

	public int compareTo(Human man) {

		if (name.compareTo(man.getName()) < 0) {

			return -1;

		} else if (name.compareTo(man.getName()) > 0){

			return 1;

		} else {

			return 0;
		}
	}
}
