package cn.newtouch.Topic.thread;

//常用关闭线程的方法 
//在线程中定义一个boolean型 
//当其为false时 线程执行完成 
//在线程对象中提供设置其为false的方法 
public class TestThread4
{
    public static void main(String args[])
    {
        Runner4 r = new Runner4();
        Thread t = new Thread(r);
        t.start();
        for (int i = 0; i < 100000; i++)
        {
            if (i % 10000 == 0 & i > 0)
            {
                System.out.println("in thread main i=" + i);
            }
        }
        System.out.println("Thread main is over");
        r.shutDown();
        // t.stop();
    }
}

class Runner4 implements Runnable
{
    private boolean flag = true;

    public void run()
    {
        int i = 0;
        while (flag == true)
        {
            System.out.print(" " + i++);
        }
    }

    public void shutDown()
    {
        flag = false;
    }
}