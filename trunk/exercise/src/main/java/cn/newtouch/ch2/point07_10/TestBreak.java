package cn.newtouch.ch2.point07_10;

public class TestBreak
{
    public static void main(String args[])
    {
        int stop = 4;
        for (int i = 1; i <= 10; i++)
        {
            // 当i等于stop时，退出循环
            if (i == stop)
            {
                ;
            }
            break;
            // System.out.println(" i= " + i); 出错
        }
    }
}
