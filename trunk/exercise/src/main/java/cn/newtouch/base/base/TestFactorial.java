package cn.newtouch.base.base;

import java.util.HashSet;
import java.util.Set;

//阶乘
public class TestFactorial
{
    private String[]    shuzijihe = new String[] { "1", "2", "3", "4" };

    private Set<String> sets      = new HashSet<String>();

    public static void main(String[] args)
    {
        new TestFactorial().start();

    }

    private void start()
    {
        for (String shuzi : this.shuzijihe)
        {
            this.depthFirstSearch(shuzi);
        }
        System.out.println(this.sets.size());
        for (String str : this.sets)
        {
            System.out.println("===" + str);
        }
    }

    private void depthFirstSearch(String str)
    {
        if (str.length() == this.shuzijihe.length)
        {
            this.sets.add(str);
        }
        else
        {
            for (String shuzi : this.shuzijihe)
            {
                if (str.indexOf(shuzi) < 0)
                {
                    String ccc = str + shuzi;
                    this.depthFirstSearch(ccc);
                }
            }
        }
    }
}