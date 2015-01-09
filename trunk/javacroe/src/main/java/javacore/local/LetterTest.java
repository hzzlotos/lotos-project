package javacore.local;

import java.text.Collator;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

import com.google.common.collect.Lists;

public class LetterTest
{
    public static void main(String[] args)
    {
        Collator coll = Collator.getInstance(Locale.CHINA);
        String a = "able";
        String b = "America";
        String c = "able";
        // 大于0表示a大于b
        // 小于0表示a小于b
        // 等于0表示a=b
        System.out.println(coll.compare(a, b));
        System.out.println(coll.compare(a, c));

        List<String> list = Lists.newArrayList();
        list.add("abcd");
        list.add("123");
        list.add("aaaaaaaaaaa");
        Collections.sort(list, coll);
        for (String str : list)
        {
            System.out.println("========" + str);
        }
    }
}