package cn.newtouch.base.base;

public class BaseTypeTest
{

    public static void main(String[] args)
    {
        myEquals();
        mathtest();
        stingTest();
        other();
    }

    private static void mathtest()
    {
        System.out.println("=====float====="
                + (float) (Math.rint(387.8915 * 10 / 100) / 10));

        // 舍掉小数取整:=3
        System.out.println("==舍掉小数取整 ===:" + Math.floor(3.5));
        // 四舍五入取整:=4
        System.out.println("==四舍五入取整 ===:" + Math.rint(3.4));
        System.out.println("==四舍五入取整 ===:" + Math.rint(3.5));
        // 进位取整:=4
        System.out.println("==进位取整 =======:" + Math.ceil(3.1));

        // wrong
        // System.out.println("==========" + ((Long) "1") + "=============");
    }

    private static void myEquals()
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

    private static void other()
    {
        System.out.println("=======================");
        int aaa = 1 * 100 / 3;

        System.out.println(aaa);
        System.out.println("=======================");
        double bb = 123.12;

        int cc = (int) bb;

        System.out.println(cc);
        System.out.println("=======================");
        int aa = 757;
        String ss = String.valueOf(aa);

        float ff = Float.valueOf(ss);

        System.out.println(ff);
        System.out.println("=======================");

        float fff = (float) bb;

        System.out.println(fff);
        System.out.println("=======================");

        float ffas = 1321.58f;

        System.out.println(ffas);

        System.out.println("=======================");

    }

    public static void stingTest()
    {
        String aaa = "0";
        String bbb = aaa;
        String ccc = bbb;
        System.out.println("aaa=" + aaa);
        System.out.println("bbb=" + bbb);
        System.out.println("ccc=" + ccc);
        aaa = "1";
        System.out.println("aaa=" + aaa);
        System.out.println("bbb=" + bbb);
        System.out.println("ccc=" + ccc);
    }
}
