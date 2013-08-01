package cn.newtouch.util;

import java.util.Random;

public class CommonUtils
{
    public static int getRandomNumber(int number)
    {
        if (number <= 0)
        {
            return 0;
        }
        Random random = new Random();
        return random.nextInt(number);
    }
}