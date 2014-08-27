package com.drcl;

public class Circumference
{
    public static void main(String[] args)
    {
        double result = 0;
        double LOOP = 100000000;
        double x = 0;
        double y = 0;
        for (int i = 0; i < LOOP; i++)
        {
            x = Math.random();
            y = Math.random();
            if (x * x + y * y < 1)
            {
                result++;
            }
        }
        // 根据1*1的方格面积为1,而落入1/4圆的面积的概率来求解
        System.out.println((result / LOOP) * 4);
    }
}