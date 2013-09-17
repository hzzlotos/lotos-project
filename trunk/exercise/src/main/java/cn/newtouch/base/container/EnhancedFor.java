package cn.newtouch.base.container;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class EnhancedFor
{
    public static void main(String[] args)
    {
        int[] arr = { 1, 2, 3, 4, 5 };
        for (int i : arr)
        {
            System.out.println(i);
        }

        Collection c = new ArrayList();
        c.add(new String("aaa"));
        c.add(new String("bbb"));
        c.add(new String("ccc"));
        for (Object o : c)
        {
            System.out.println(o);
        }

        System.out.println("====================");
        Set s1 = new HashSet();
        s1.add(1);
        s1.add(2);
        s1.add(3);
        Set s2 = new HashSet();
        s2.add(2);
        s2.add(3);
        s2.add(4);
        Set bbb = new HashSet(s1);
        bbb.retainAll(s2);
        for (Object o : bbb)
        {
            System.out.println(o);
        }
    }
}