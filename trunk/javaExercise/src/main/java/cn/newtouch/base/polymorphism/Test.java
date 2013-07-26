package cn.newtouch.base.polymorphism;

//多态
abstract class Animal
{
    private String name;

    Animal(String name)
    {
        this.name = name;
    }

    // public void enjoy()
    // {
    // System.out.println("叫声......");
    // }

    public abstract void enjoy();
}

class Cat extends Animal
{
    private String eyesColor;

    Cat(String n, String c)
    {
        super(n);
        eyesColor = c;
    }

    @Override
    public void enjoy()
    {
        System.out.println("猫叫声......");
    }

    // public abstract void enjoy();
}

class Dog extends Animal
{
    private String furColor;

    Dog(String n, String c)
    {
        super(n);
        furColor = c;
    }

    @Override
    public void enjoy()
    {
        System.out.println("狗叫声......");
    }
}

class Bird extends Animal
{
    Bird()
    {
        super("bird");
    }

    @Override
    public void enjoy()
    {
        System.out.println("鸟叫声......");
    }
}

class Lady
{
    private String name;

    private Animal pet;

    Lady(String name, Animal pet)
    {
        this.name = name;
        this.pet = pet;
    }

    public void myPetEnjoy()
    {
        pet.enjoy();
    }
}

public class Test
{
    public static void main(String args[])
    {
        Cat c = new Cat("catname", "blue");
        Dog d = new Dog("dogname", "black");
        Bird b = new Bird();
        Lady l1 = new Lady("l1", c);
        Lady l2 = new Lady("l2", d);
        Lady l3 = new Lady("l3", b);
        l1.myPetEnjoy();
        l2.myPetEnjoy();
        l3.myPetEnjoy();
    }
}
