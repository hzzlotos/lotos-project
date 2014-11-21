package javacore.local;

import java.text.MessageFormat;
import java.util.GregorianCalendar;

public class MessageTest
{
    public static void main(String[] args)
    {
        String msg = MessageFormat.format("On {2}, a {0} destroyed {1} houses and caused {3} of damage.", "hurricane",
                99, new GregorianCalendar(1990, 0, 1).getTime(), 10.0E8);
        System.out.println(msg);
        System.out.println("=======================================");
        // 占位符标记后面可以跟一个类型(type)与一个风格(style),之间用逗号隔开
        msg = MessageFormat.format(
                "On {2,date,long}, a {0} destroyed {1} houses and caused {3,number,currency} of damage.", "hurricane",
                99, new GregorianCalendar(1990, 0, 1).getTime(), 10.0E8);
        System.out.println(msg);
    }
}