package cn.newtouch.base.base.math;

import java.util.List;

public class Main
{

    public static void main(String[] args)
    {

        int[] aaa = { 2, 5, 6 };

        int m = 3;

        Math0708 math = new Math0708();
        for (int i : aaa)
        {
            System.out.println(i);
        }

        List<Integer[]> sss = math.math0708(aaa, m);

        System.out.println("size = " + sss.size());

        System.out.println("---------------");

        String bbb = "";

        for (Integer[] kkk : sss)
        {
            for (Integer i : kkk)
            {
                bbb += i + " ";
            }
        }

        System.out.println("[" + bbb + "]");

    }
}
