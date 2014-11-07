package cn.newtouch.getlevel.level;

import java.io.File;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Test
{
    private static String path1 = Test.class.getClassLoader().getResource("").getPath() + "cn" + File.separator
                                        + "newtouch" + File.separator + "getlevel" + File.separator + "entities";

    public static void main(String[] args) throws Exception
    {
        File f = new File(path1);
        String[] classNames = f.list();
        // delete(classNames);
        getNodeByClass(classNames);
    }

    private static void getNodeByClass(String[] classNames) throws Exception
    {
        List<KeyValue<String, Integer>> result = new ArrayList<KeyValue<String, Integer>>();
        List<KeyValue<String, Set<KeyValue<String, Integer>>>> temp = new ArrayList<KeyValue<String, Set<KeyValue<String, Integer>>>>();
        String name;
        KeyValue<String, Set<KeyValue<String, Integer>>> keyValue;
        Set<KeyValue<String, Integer>> fieldNames = new HashSet<KeyValue<String, Integer>>();
        for (String s : classNames)
        {
            if (s.contains("Key.java") || s.equals("level"))
            {
                continue;
            }
            name = s.replace(".class", "");
            Class clazz = Class.forName("cn.newtouch.getlevel.entities." + name);
            Field[] fields = clazz.getDeclaredFields();
            fieldNames = new HashSet<KeyValue<String, Integer>>();
            for (Field f : fields)
            {
                if (!f.getType().equals(Long.class) && !f.getType().equals(String.class)
                        && !f.getType().equals(Date.class) && !f.getType().equals(BigDecimal.class)
                        && !f.getType().equals(long.class) && !f.getType().equals(List.class))
                {

                    fieldNames
                            .add(new KeyValue(f.getType().getName().replace("cn.newtouch.getlevel.entities.", ""), -1));
                }
            }
            keyValue = new KeyValue(name, fieldNames);
            if (!temp.contains(keyValue))
            {
                temp.add(keyValue);
            }

        }
        get(temp, result);
        System.out.println("=========OK+++++++++");
        for (KeyValue<String, Integer> str : result)
        {
            System.out.println(str.getKey() + "====" + str.getValue());
        }
    }

    private static void get(List<KeyValue<String, Set<KeyValue<String, Integer>>>> source,
            List<KeyValue<String, Integer>> result)
    {
        if (source.isEmpty())
        {
            return;
        }
        Set<KeyValue<String, Integer>> fieldNames = new HashSet<KeyValue<String, Integer>>();
        KeyValue<String, Integer> keyValue;
        boolean flag = true;
        Integer max = 0;
        for (KeyValue<String, Set<KeyValue<String, Integer>>> temp : source)
        {
            fieldNames = temp.getValue();
            if (null == fieldNames || fieldNames.isEmpty())
            {
                keyValue = new KeyValue(temp.getKey(), 1);
                result.add(keyValue);
            }
            else
            {
                max = 0;
                flag = true;
                for (KeyValue<String, Integer> temp2 : fieldNames)
                {
                    if (!result.contains(temp2))
                    {
                        if (temp2.getKey().equals(temp.getKey()))
                        {
                            flag = true;
                        }
                        else
                        {
                            flag = false;
                            break;
                        }
                    }
                    else
                    {
                        keyValue = result.get(result.indexOf(temp2));
                        max = max >= keyValue.getValue() ? max : keyValue.getValue();
                    }
                }
                if (flag)
                {
                    keyValue = new KeyValue<String, Integer>(temp.getKey(), max + 1);
                    result.add(keyValue);
                }
            }
        }
        for (KeyValue<String, Integer> str : result)
        {
            if (source.contains(str))
            {
                source.remove(str);
            }
            // System.out.println(str.getKey() + "====" + str.getValue());
        }
        // System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        get(source, result);
    }

    private static void delete(String[] classNames) throws Exception
    {
        File file = null;
        for (String s : classNames)
        {
            if (s.contains("Example.java"))
            {
                file = new File(path1 + "//" + s);
                file.delete();
            }
        }
        System.out.println("===delete===jieshule");
    }
}