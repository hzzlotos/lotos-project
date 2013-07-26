package cn.newtouch.base.base;

public class TestConvert
{
    public static void main(String arg[])
    {
        int i = 1, j;

        // float f1 = 0.1, f2 = 123;
        float f1 = 0.1F, f2 = 123;// 必须加上F 因为不加F默认为double型,而double不可自动转成float型
        double d1 = 2e20, d2 = 124;

        // byte b1 = 1, b2 = 2, b3 = 129;
        byte b1 = 1, b2 = 2;// b3已经超过byte类型的范围了 -128~~~127
        char c1 = 'a', c2 = 125;

        System.out.println("=========================");

        j = 1 + 10;
        System.out.println("j===" + j);
        i = 1 / 10;// 精度被强转
        System.out.println("i===" + i);
        // i = 1 * 0.1;
        i = (int) (1 * 0.1);// 精度被强转
        System.out.println("i===" + i);
        // byte b = b1 - b2;
        byte b = (byte) (b1 - b2);
        System.out.println("b===" + b);
        // char c = c1 + c2 - 1;
        char c = (char) (c1 + c2 - 1);
        System.out.println("c===" + c);
        // float f3 = f1 + f2, f4 = f1 + f2 * 0.1;
        float f3 = f1 + f2, f4 = (float) (f1 + f2 * 0.1), f5 = 1;
        System.out.println("f3===" + f3);
        System.out.println("f4===" + f4);
        System.out.println("f5===" + f5);
        double d = d1 * i + j;
        System.out.println("d===" + d);
        float f = (float) (d1 * 5 + d2);
        System.out.println("f===" + f);

    }
}
