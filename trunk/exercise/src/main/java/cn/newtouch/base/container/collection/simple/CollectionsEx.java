package cn.newtouch.base.container.collection.simple;

import java.util.List;
import java.util.Random;

public class CollectionsEx {

	public <T> List<T> shuffle(List<T> list, int time){

		int length = list.size();

		Random ran = new Random();

		for (int i = 0; i < (time + 1); i++){

			int first = ran.nextInt(length);

			int second = ran.nextInt(length);

			T o = list.get(first);

			list.set(first,list.get(second));

			list.set(second,o);
		}

		return list;
	}
}
