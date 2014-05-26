package cn.newtouch.base.base.random;

import java.util.Random;

public class RandomTest
{

    /**
     * Description of this Method
     * 
     * @since 2011-8-26
     * @author zzHe
     * @param args
     */
    public static void main(String[] args)
    {
        Random random = new Random();
        // int i = random.nextInt(0);
        int i = random.nextInt(1);
        System.out.println("==============" + i);
    }

}
