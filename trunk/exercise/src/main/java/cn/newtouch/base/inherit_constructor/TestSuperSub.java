package cn.newtouch.base.inherit_constructor;

class SuperClass
{
    private int n;

    SuperClass()
    {
        System.out.println("SuperClass()");
    }

    SuperClass(int n)
    {
        System.out.println("SuperClass(" + n + ")");
        this.n = n;
    }
}

class SubClass extends SuperClass
{
    private int n;

    SubClass(int n)
    {
        // super();
        System.out.println("SubClass(" + n + ")");
        this.n = n;
    }

    SubClass()
    {
        super(300);
        System.out.println("SubClass()");
    }
}

public class TestSuperSub
{
    public static void main(String arg[])
    {
        new SubClass(400);
    }
}
