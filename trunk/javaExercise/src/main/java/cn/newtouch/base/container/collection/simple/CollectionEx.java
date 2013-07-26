package cn.newtouch.base.container.collection.simple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class CollectionEx
{

    private Println prln = new Println();

    public void arraylist()
    {

        String[] str = { "12", "34" };

        Set<String> aaa = new HashSet<String>();

        aaa.add("1");

        aaa.add("2");

        aaa.add("3");

        new ArrayList<String>(aaa);

        Arrays.asList(str);

        ArrayList<Integer> list = new ArrayList<Integer>();

        list.add(123);

        list.add(485);

        prln.print("第二位", list.get(1));

        list.add(1, 345);

        prln.print("第二位", list.get(1));

        list.set(1, 234);

        prln.print("第二位", list.get(1));

        int index = list.indexOf(123);

        prln.print("index", index);

        Iterator i = list.iterator();

        prln.print();

        while (i.hasNext())
        {

            prln.print("第" + i + "位", i.next());
        }

        list.remove(1);

        list.add(12345);

        list.remove((Integer) 12345);

        i = list.iterator();

        prln.print();

        while (i.hasNext())
        {

            prln.print("第" + i + "位", i.next());
        }
    }

    public void linkedlist()
    {

        LinkedList<Integer> list = new LinkedList<Integer>();

        list.add(123);

        list.add(234);

        prln.print("第二位", list.get(1));

        list.add(1, 345);

        prln.print("第二位", list.get(1));

        list.set(1, 234);

        prln.print("第二位", list.get(1));

        int index = list.indexOf(123);

        prln.print("index", index);

        Iterator i = list.iterator();

        prln.print();

        while (i.hasNext())
        {

            prln.print("第" + i + "位", i.next());
        }

        list.addFirst(12345);

        list.addLast(67890);

        prln.print("第一位", list.getFirst());

        prln.print("最后位", list.getLast());

        i = list.iterator();

        prln.print();

        while (i.hasNext())
        {

            prln.print("第" + i + "位", i.next());
        }

        list.removeFirst();

        list.removeLast();

        i = list.iterator();

        prln.print();

        while (i.hasNext())
        {

            prln.print("第" + i + "位", i.next());
        }

        list.add(43535);

        list.add(987456);

        list.remove(1);

        list.remove((Integer) 987456);

        i = list.iterator();

        prln.print();

        while (i.hasNext())
        {

            prln.print("第" + i + "位", i.next());
        }
    }

    public void treemap()
    {

        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();

        map.put(4, 4);

        map.put(3, 3);

        map.put(2, 2);

        map.put(1, 1);

        map.put(5, 5);

        prln.print("长度", map.size());

        Set<Map.Entry<Integer, Integer>> set = map.entrySet();

        prln.print();

        for (Map.Entry<Integer, Integer> e : set)
        {

            prln.print("key", e.getKey());

            prln.print("value", e.getValue());
        }

        map.remove(2);

        set = map.entrySet();

        prln.print();

        for (Map.Entry<Integer, Integer> e : set)
        {

            prln.print("key", e.getKey());

            prln.print("value", e.getValue());
        }
    }

    public void hashmap()
    {

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        map.put(4, 4);

        map.put(3, 3);

        map.put(2, 2);

        map.put(1, 1);

        map.put(5, 5);

        prln.print("长度", map.size());

        Set<Map.Entry<Integer, Integer>> set = map.entrySet();

        prln.print();

        for (Map.Entry<Integer, Integer> e : set)
        {

            prln.print("key", e.getKey());

            prln.print("value", e.getValue());
        }

        map.remove(2);

        set = map.entrySet();

        prln.print();

        for (Map.Entry<Integer, Integer> e : set)
        {

            prln.print("key", e.getKey());

            prln.print("value", e.getValue());
        }
    }

    public void linkedmap()
    {

        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<Integer, Integer>();

        map.put(4, 4);

        map.put(3, 3);

        map.put(2, 2);

        map.put(1, 1);

        map.put(5, 5);

        prln.print("长度", map.size());

        Set<Map.Entry<Integer, Integer>> set = map.entrySet();

        prln.print();

        for (Map.Entry<Integer, Integer> e : set)
        {

            prln.print("key", e.getKey());

            prln.print("value", e.getValue());
        }

        map.remove(2);

        set = map.entrySet();

        prln.print();

        for (Map.Entry<Integer, Integer> e : set)
        {

            prln.print("key", e.getKey());

            prln.print("value", e.getValue());
        }
    }

    public void hashset()
    {

        List<String> sss = new ArrayList<String>();

        sss.add("1");

        sss.add("2");

        sss.add("3");

        new HashSet<String>(sss);

        HashSet<Integer> set = new HashSet<Integer>();

        set.add(3);

        set.add(2);

        set.add(2);

        set.add(1);

        Iterator i = set.iterator();

        prln.print();

        while (i.hasNext())
        {

            prln.print("set", i.next());
        }

        set.remove(2);

        i = set.iterator();

        prln.print();

        while (i.hasNext())
        {

            prln.print("set", i.next());
        }
    }

    public void linkedset()
    {

        LinkedHashSet<Integer> set = new LinkedHashSet<Integer>();

        set.add(3);

        set.add(2);

        set.add(1);

        Iterator i = set.iterator();

        prln.print();

        while (i.hasNext())
        {

            prln.print("set", i.next());
        }

        set.remove(2);

        i = set.iterator();

        prln.print();

        while (i.hasNext())
        {

            prln.print("set", i.next());
        }
    }

    public void treeset()
    {

        TreeSet<Integer> set = new TreeSet<Integer>();

        set.add(3);

        set.add(2);

        set.add(1);

        Iterator i = set.iterator();

        prln.print();

        while (i.hasNext())
        {

            prln.print("set", i.next());
        }

        set.remove(2);

        i = set.iterator();

        prln.print();

        while (i.hasNext())
        {

            prln.print("set", i.next());
        }
    }
}
