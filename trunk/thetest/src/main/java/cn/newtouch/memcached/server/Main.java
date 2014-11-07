package cn.newtouch.memcached.server;

public class Main
{
    public static Main         main = new Main();

    public static ICacheServer test;

    public static void main(String[] args)
    {
        try
        {
            test = MemcachedServer.init();
            System.out.println("===============" + test.save("hello", "Hello,xmemcached"));
            Object value = test.get("hello");
            System.out.println("hello=" + value.toString());
            test.delete("hello");
            value = test.get("hello");
            if (null != value)
            {
                System.out.println("hello=" + value.toString());
            }
            else
            {
                System.out.println("is null");
            }
            System.out.println("===================================================================================");
            for (int i = 0; i < 10; i++)
            {
                main.new TestTheard("key", "value" + i).start();
            }
            // memcachedClient.shutdown();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private class TestTheard extends Thread
    {
        private String key;

        private String value;

        public TestTheard(String key, String value)
        {
            this.key = key;
            this.value = value;
        }

        @Override
        public void run()
        {
            try
            {
                if (test.save(this.key, this.value))
                {
                    System.out.println("this is " + this.value + "===============" + test.get("key"));
                }
            }
            catch (Exception e)
            {
                System.out.println("error: the value ======" + this.value);
                e.printStackTrace();
            }
        }

    }
}
