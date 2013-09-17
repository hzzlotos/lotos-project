package cn.newtouch.ch2.point06;

public class TestLogic
{
    public static void main(String[] args)
    {
        boolean a = true, b = false, c;
        c = a & b;
        System.out.println("1=" + c);
        c = a | b;
        System.out.println("2=" + c);
        c = a ^ b; // 异或,相异为true
        System.out.println("3=" + c);
        c = true ^ true; // 异或,相异为true
        System.out.println("4=" + c);
        c = !a;
        System.out.println("5=" + c);
        c = a && b;
        System.out.println("6=" + c);
        c = a || b;
        System.out.println("7=" + c);

        int i = 1, j = 2;
        boolean flag1 = (i > 3) && ((i + j) > 5);// 当第一个为false之后第二个操作数将不再计算
        System.out.println(flag1);
        boolean flag2 = (i < 3) || ((i + j) < 6);// 当第一个为true之后第二个操作数将不再计算
        System.out.println(flag2);
    }
}