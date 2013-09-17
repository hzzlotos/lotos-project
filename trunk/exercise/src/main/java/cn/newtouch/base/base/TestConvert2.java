package cn.newtouch.base.base;

public class TestConvert2
{
    public static void main(String[] args)
    {
        byte b1 = 67;
        byte b2 = 89;
        byte b3 = (byte) (b1 + b2);// 系统将转换为int型运算，需
        // 要强制转换符
        System.out.println(b3);

        char c1 = 'a', c2 = 125;
        System.out.println("c1===" + c1);
        System.out.println("c2===" + c2);
    }
}