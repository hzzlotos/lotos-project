package javacore.set;

import java.util.HashMap;
import java.util.Map;

public class TheEQTest
{

    public static void main(String[] args)
    {
        Man a = new Man(1, "111");
        Man b = new Man(2, "222");
        Map<Man, String> maps = new HashMap<>();
        maps.put(a, "11111");
        maps.put(b, "22222");
        maps.put(a, "33333");
        System.out.println(hash(a));
        System.out.println(hash(b));
    }

    static int hash(Object k)
    {
        int h = 0;
        if (0 != h && k instanceof String)
        {
            return sun.misc.Hashing.stringHash32((String) k);
        }

        h ^= k.hashCode();

        // This function ensures that hashCodes that differ only by
        // constant multiples at each bit position have a bounded
        // number of collisions (approximately 8 at default load factor).
        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
    }
}
