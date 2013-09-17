package cn.newtouch.base.container.collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Sett
{

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        Set<String> sett = new HashSet<String>();

        sett.add("1");
        sett.add("2");
        sett.add("1");
        sett.add("3");
        sett.add("4");
        sett.add("5");
        Iterator<String> ii = sett.iterator();
        while (ii.hasNext())
        {
            System.out.println(ii.next());
        }
        System.out.println("=============================");
        for (String aaa : sett)
        {
            System.out.println(aaa);
        }
    }

}
