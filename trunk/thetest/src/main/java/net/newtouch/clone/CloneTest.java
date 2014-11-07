package net.newtouch.clone;

public class CloneTest
{
    public static void main(String[] args)
    {
        B b = new B(1);
        A a = new A(2, b);
        A a2 = a.clone();
        System.out.println("===a.hashcode=" + a.hashCode());
        System.out.println("===a2.hashcode=" + a2.hashCode());
        System.out.println("=========================================");
        System.out.println("===a.a=" + a.getA());
        System.out.println("===a2.a=" + a2.getA());
        System.out.println("=========================================");
        System.out.println("===a.b.hashcode=" + a.getbObject().hashCode());
        System.out.println("===a2.b.hashcode=" + a2.getbObject().hashCode());
        System.out.println("=========================================");
        System.out.println("===a.b=" + a.getbObject().getB());
        System.out.println("===a2.b=" + a2.getbObject().getB());
    }
}

class A implements Cloneable
{
    private int a;

    private B   bObject;

    public A(int a, B bObject)
    {
        this.a = a;
        this.bObject = bObject;
    }

    public int getA()
    {
        return this.a;
    }

    public void setA(int a)
    {
        this.a = a;
    }

    public B getbObject()
    {
        return this.bObject;
    }

    public void setbObject(B bObject)
    {
        this.bObject = bObject;
    }

    @Override
    public A clone()
    {
        // 注意此处要把protected改为public
        try
        {
            A a = (A) super.clone();
            a.setbObject(a.getbObject().clone());
            return a;
        }
        catch (CloneNotSupportedException e)
        {
            e.printStackTrace();
        }
        return null;
    }
}

class B implements Cloneable
{
    private int b;

    public B(int b)
    {
        this.b = b;
    }

    public int getB()
    {
        return this.b;
    }

    public void setB(int b)
    {
        this.b = b;
    }

    @Override
    public B clone()
    {
        // 注意此处要把protected改为public
        try
        {
            return (B) super.clone();
        }
        catch (CloneNotSupportedException e)
        {
            e.printStackTrace();
        }
        return null;
    }
}