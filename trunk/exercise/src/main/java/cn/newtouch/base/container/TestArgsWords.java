package cn.newtouch.base.container;

import java.util.HashMap;
import java.util.Map;

public class TestArgsWords
{
    // private static final Integer ONE = new Integer(1);
    private static final int ONE = 1;

    public static void main(String args[])
    {
        Map m = new HashMap();
        for (String arg : args)
        {
            // Integer freq = (Integer) m.get(args[i]);

            int freq = (Integer) m.get(arg) == null ? 0 : (Integer) m.get(arg);
            // m.put(args[i],(freq == null? ONE : new Integer(freq.intValue() +
            // 1)));
            m.put(arg, freq == 0 ? ONE : freq + 1);
        }
        System.out.println(m.size() + " distinct words detected:");
        System.out.println(m);
    }
}
