package cn.newtouch.base.test_final;

public class TestFinal
{
    public static void main(String[] args)
    {
        new T();
    }
}

final class T
{
    final int i = 8;

    public final void m()
    {
        // j = 9;
    }
}
// 报错
// class TT extends T
// {
//
// }