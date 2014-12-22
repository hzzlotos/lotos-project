package javacore.set;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

public class TheTest
{

    public static void main(String[] args)
    {
        Set<Integer> intSet = Sets.newHashSet();
        intSet.add(1);
        intSet.add(2);
        intSet.add(3);
        intSet.add(4);
        intSet.add(5);
        intSet.add(6);

        for (Integer i : intSet)
        {
            if (i < 3)
            {
                // intSet.remove(i); //报错
            }
        }

        List<Integer> intList = Lists.newArrayList();
        intList.add(1);
        intList.add(2);
        intList.add(3);
        intList.add(4);
        intList.add(5);
        intList.add(6);

        for (Integer i : intList)
        {
            if (i < 3)
            {
                // intList.remove(i);
            }
        }

        Map<Integer, Integer> intMap = Maps.newHashMap();
        intMap.put(1, 1);
        intMap.put(2, 2);
        intMap.put(3, 3);
        intMap.put(4, 4);
        intMap.put(5, 5);
        intMap.put(6, 6);

        for (Integer i : intMap.keySet())
        {
            if (i < 3)
            {
                intMap.remove(i);
            }
        }
    }
}