package cn.newtouch.service;

public class DoSomeThing extends Thread
{
    int length = 10000;

    @Override
    public void run()
    {
        int i = 0;
        while (i++ < this.length)
        {
            if (i % 100 == 0)
            {
                System.out.println("the time===" + i);
                TestService.setprogress(this.getId(), i * 100 / (double) this.length);
                try
                {
                    sleep(1000);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }
}