package cn.newtouch.base.inherit;

//继承
class FatherClass
{
    private int value;

    public void f()
    {
        value = 100;
        System.out.println("FatherClass.value=" + value);
    }

    public void setValue(int value)
    {
        this.value = value;
    }

    public int getValue()
    {
        return value;
    }

}

class ChildClass extends FatherClass
{
    private int value;

    @Override
    public void f()
    {
        super.f();
        value = 200;
        System.out.println("ChildClass.value=" + value);
        System.out.println(value);
        System.out.println(super.getValue());
    }

    @Override
    public void setValue(int value)
    {
        this.value = value;
    }

    @Override
    public int getValue()
    {
        return value;
    }
}

public class TestInherit
{
    public static void main(String[] args)
    {
        ChildClass cc = new ChildClass();
        cc.f();
    }
}
