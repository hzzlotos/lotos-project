package cn.newtouch.base.container.collection.simple;

import java.util.Comparator;

public class MyComparator implements Comparator<Human> {

	public int compare(Human o1, Human o2) {

		if (o1.getName().compareTo(o2.getName()) < 0) {

			return -1;

		} else if (o1.getName().compareTo(o2.getName()) > 0){

			return 1;

		} else {

			return 0;
		}
	}
}
