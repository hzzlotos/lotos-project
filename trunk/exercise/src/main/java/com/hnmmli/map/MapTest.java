package com.hnmmli.map;

import java.util.Map;

import com.google.common.collect.Maps;

public class MapTest
{
    public static void main(String[] args)
    {
        Map<String, String> map = Maps.newHashMap();
        map.put("1", null);

        System.out.println("=====" + map.get("1"));
        String a = map.put("1", "1");
        System.out.println("=====" + map.get("1"));
        System.out.println("==a===" + a);
    }
}
