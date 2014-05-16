package com.hnmmli.thread.syntest;

public class Buffer
{
    public static final Object[] items = new Object[5]; // new Object[100]; // 缓存队列

    public static int            putptr;               /* 写索引 */

    public static int            takeptr;              /* 读索引 */

    public static int            count;                /* 队列中存在的数据个数 */

    public static void main(String[] args)
    {
        BoundedBuffer1 test1 = new BoundedBuffer1();
        BoundedBuffer2 test2 = new BoundedBuffer2();
        Thread aa = new A(test1);
        Thread bb = new B(test2);
        aa.start();
        bb.start();
    }
}
