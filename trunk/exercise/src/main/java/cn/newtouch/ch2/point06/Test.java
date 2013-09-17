package cn.newtouch.ch2.point06;

public class Test
{
    public static void main(String[] args)
    {
        int i1 = 10, i2 = 20;
        int i = (i2++); // 先取值 后运算
        System.out.println("i=" + i);
        System.out.println("i2=" + i2);
        i = (++i2); // 先运算 后取值
        System.out.println("i=" + i);
        System.out.println("i2=" + i2);
        i = (--i1);
        System.out.println("i=" + i);
        System.out.println("i1=" + i1);
        i = (i1--);
        System.out.println("i=" + i);
        System.out.println("i1=" + i1);
    }
}