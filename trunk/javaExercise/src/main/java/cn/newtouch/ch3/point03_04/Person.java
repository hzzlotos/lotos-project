package cn.newtouch.ch3.point03_04;

public class Person
{
    int id;

    int age = 20;

    void Person(int _id, int _age)
    {
        this.id = _id;
        this.age = _age;
    }

    Person(int _id, int _age)
    {
        this.id = _id;
        this.age = _age;
    }

    Person()
    {
    }

    public static void main(String[] args)
    {
        Person tom = new Person();
        tom.Person(1, 25);
        Person tom1 = new Person(1, 25);
        System.out.println(tom1.id);
        System.out.println(tom1.age);
        Point p = new Point();
        System.out.println(p.toString());
    }
}

class Point
{
    Point()
    {
    }

    int x;

    int y;
}