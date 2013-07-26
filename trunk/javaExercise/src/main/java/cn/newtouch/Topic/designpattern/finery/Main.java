package cn.newtouch.Topic.designpattern.finery;

public class Main
{

    public static void main(String[] args)
    {

        Person ps = new Person("xiaohe");

        TShirts ts = new TShirts("xiaozhang");

        ts.Decorate(ps);

        ts.show();

        System.out.println("=====================");

        System.out.println(ts.getName());
    }
}