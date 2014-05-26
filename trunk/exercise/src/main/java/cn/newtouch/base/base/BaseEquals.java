package cn.newtouch.base.base;

public class BaseEquals
{
    public static void main(String[] args)
    {
        double a111 = 0.11;

        float a222 = 0.11F;
        double a333 = 0.11;
        float a444 = 0.11F;
        System.out.println("num=" + (a111 - a222));
        System.out.println("======================================");
        if (a111 == a222)
        {
            System.out.println("我们是相等的");
        }
        else
        {
            System.out.println("我们居然不相等");
        }
        System.out.println("======================================");
        if (a111 == a333)
        {
            System.out.println("我们是相等的");
        }
        else
        {
            System.out.println("我们居然不相等");
        }
        System.out.println("======================================");
        if (a222 == a444)
        {
            System.out.println("我们是相等的");
        }
        else
        {
            System.out.println("我们居然不相等");
        }
    }

}
