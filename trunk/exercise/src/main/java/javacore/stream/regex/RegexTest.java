package javacore.stream.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest
{

    public static void main(String[] args)
    {
        Pattern pattern = Pattern.compile("^a\\w{2,5}\\W{1}\\w*");
        Matcher matcher = pattern.matcher("aabb,b");
        if (matcher.matches())
        {
            System.out.println("匹配正确！");
        }
        else
        {
            System.out.println("匹配不正确！");
        }

        pattern = Pattern.compile("\\d+");
        matcher = pattern.matcher("aaa123dfff55fdfg6");
        String aaa = matcher.replaceAll("#");
        System.out.println("=====" + aaa);

        pattern = Pattern.compile("\\d+");
        matcher = pattern.matcher("aaa123dfff55fdfg6");
        String bbb = matcher.replaceFirst("#");
        System.out.println("=====" + bbb);

        pattern = Pattern.compile("\\d+");
        String[] strs = pattern.split("aaa123dfff55fdfg6");
        System.out.println("====" + strs[0] + "====" + strs[1] + "====" + strs[2] + "====" + strs.length);
    }
}