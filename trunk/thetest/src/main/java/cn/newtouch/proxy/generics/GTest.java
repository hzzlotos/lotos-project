package cn.newtouch.proxy.generics;

public class GTest extends Generics<String, String>
{

    @Override
    protected Class<String> getTheClass()
    {
        return String.class;
    }
}
