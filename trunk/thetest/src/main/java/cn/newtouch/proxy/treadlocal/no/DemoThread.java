package cn.newtouch.proxy.treadlocal.no;

public class DemoThread extends Thread
{

    private NumCreator creator;

    public DemoThread(NumCreator creator)
    {
        this.creator = creator;
    }

    @Override
    public void run()
    {
        // 使用数字生成器生成三个数字
        for (int i = 0; i < 3; i++)
        {
            System.out.println(Thread.currentThread().getName() + "print num:" + this.creator.getNextNum());
        }
    }
}
