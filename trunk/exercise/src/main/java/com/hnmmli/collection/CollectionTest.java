package com.hnmmli.collection;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.google.common.collect.Lists;

public class CollectionTest
{

    public static void main(String[] args)
    {
        List<String> list = Arrays.asList(new String[] { "1", "2" });
        System.out.println(list.size());
        list = Arrays.asList("1", "2", "3", "5");
        System.out.println(list.size());
        // list.remove(0); 该处报错 因为Arrays.asList转换出来的并不是真正的Collection
        list = Lists.newArrayList();
        list.add("8");
        list.add("6");
        list.add("3");
        list.add("1");
        System.out.println("-----------------------------");
        List<String> subs = list.subList(0, 2);
        System.out.println(list.size());
        System.out.println(subs.size());
        System.out.println("-----------------------------");
        // 操作子列表就是对主列表进行操作
        subs.remove(1);
        System.out.println(list.size());
        System.out.println(subs.size());
        System.out.println("-----------------------------");

        Object[] strs = list.toArray();
        System.out.println(strs.length);

        // 可以使用排序是因为String继承了Comparable<String>
        Collections.sort(list);

        for (String str : list)
        {
            System.out.println("---===" + str);
        }
        System.out.println("-----------------------------");
        int index = Collections.binarySearch(list, "4");
        System.out.println(index);
        index = Collections.binarySearch(list, "1");
        System.out.println(index);
        index = Collections.binarySearch(list, "3");
        System.out.println(index);
        index = Collections.binarySearch(list, "8");
        System.out.println(index);
        System.out.println("-----------------------------");
        System.out.println(Collections.min(list));
        System.out.println(Collections.max(list));
    }

}
