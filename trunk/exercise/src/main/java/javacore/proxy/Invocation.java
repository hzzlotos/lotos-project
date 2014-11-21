package javacore.proxy;

public class Invocation implements InvocationInterface
{

    @Override
    public void sayHello()
    {
        System.out.println("Hello!");
    }

    @Override
    public void sayBye()
    {
        System.out.println("Bye!");
    }

}
