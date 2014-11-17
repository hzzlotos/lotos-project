package cn.newtouch.proxy.proxyInvoke;

public class Hello implements IHello
{
    @Override
    public void say(String aaa)
    {
        System.out.println("say hello!");
    }
}
