package cn.newtouch.base.test_interface.interfacetest;

public class Main
{

    /**
     * @param args
     */
    public static void main(String[] args)
    {

        Father man;

        man = new Father();

        man.say();

        // man.sayy();

        man = new Son();

        man.say();

        // man.sayy();

        Son son = new Son();

        son.say();

        son.sayy();
    }

}
