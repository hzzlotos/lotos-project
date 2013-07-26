package cn.newtouch.base.container;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class BasicGeneric
{
    public static void main(String[] args)
    {
        List<String> c = new ArrayList<String>();
        c.add("aaa");
        c.add("bbb");
        c.add("ccc");
        for (int i = 0; i < c.size(); i++)
        {
            String s = c.get(i);
            System.out.println(s);
        }

        Collection<String> c2 = new HashSet<String>();
        c2.add("aaa");
        c2.add("bbb");
        c2.add("ccc");
        for (String s : c2)
        {
            System.out.println(s);
        }
    }
}

class MyName implements Comparable<MyName>
{
    int age;

    public int compareTo(MyName mn)
    {
        if (this.age > mn.age)
        {
            return 1;
        }
        else
            if (this.age < mn.age)
            {
                return -1;
            }
            else
            {
                return 0;
            }
    }
}
