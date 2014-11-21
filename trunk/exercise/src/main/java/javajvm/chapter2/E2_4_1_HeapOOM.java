package javajvm.chapter2;

import java.util.ArrayList;
import java.util.List;

/**
 * VM Args：-Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=g:\dump
 */
public class E2_4_1_HeapOOM
{

    public static void main(String[] args)
    {
        List<OOMObject> list = new ArrayList<OOMObject>();
        int i = 1;
        while (true)
        {
            list.add(new OOMObject("" + i));
            i++;
        }
    }
}
