package cn.newtouch.base.container.collection.simple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	public static CollectionEx cte = new CollectionEx();

	public static void main(String[] args) {


	//	Human aa = new Human("aa",23,"M");

	//	Human bb = new Human("bb",45,"W");

		// 打乱排序方法
		/*
		List<Human> asdasd = new ArrayList<Human>();

		asdasd.add(new Human("aa",23,"M"));

		asdasd.add(new Human("bb",32,"M"));

		asdasd.add(new Human("cc",43,"W"));

		asdasd.add(new Human("dd",23,"M"));

		asdasd.add(new Human("ee",65,"W"));

		asdasd.add(new Human("ff",65,"W"));

		asdasd.add(new Human("gg",44,"M"));

		CollectionsEx ce = new CollectionsEx();

		ce.shuffle(asdasd, 3);

		for (Human sss : asdasd) {

			System.out.println(sss.getName());
		}
		*/

		// 比较大小
		/*
		MyComparator myComparator = new MyComparator();

		if (myComparator.compare(aa,bb) > 0) {

			System.out.println("aa大");

		} else if (myComparator.compare(aa,bb) < 0) {

			System.out.println("bb大");

		}else {

			System.out.println("一样大");
		}


		if (aa.equals(aa)){

			System.out.println("一个人");

		} else {

			System.out.println("不是人");
		}

		if (aa.equals(bb)){

			System.out.println("一个人");

		} else {

			System.out.println("不是人");
		}
		*/

		// LIST MAP SET 练习

		System.out.println("请输入首字母!");

		String str = read();

		while (!("".equals(str) || "end".equals(str))){

			method(str);

			str = read();
		}

	}

	private static void method(String str) {

		if (str.equals("al")){

			cte.arraylist();

		} else if (str.equals("ll")){

			cte.linkedlist();

		} else if (str.equals("lm")){

			cte.linkedmap();

		} else if (str.equals("ls")){

			cte.linkedset();

		} else if (str.equals("hm")){

			cte.hashmap();

		} else if (str.equals("hs")){

			cte.hashset();

		} else if (str.equals("tm")){

			cte.treemap();
		} else if (str.equals("ts")){

			cte.treeset();
		} else {

			System.out.println("请输入首字母!");
		}
	}

	@SuppressWarnings("finally")
	private static String read() {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String str = "";

		try {

			str = in.readLine().toLowerCase();

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			return str;
		}
	}
}
