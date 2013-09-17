package cn.newtouch.Topic.designpattern.finery;

public class Finery extends Person
{

    public Finery(String name)
    {
        super(name);
    }

    public Finery()
    {
    }

    protected Person component;

    public void Decorate(Person component)
    {

        this.component = component;
    }

    @Override
    public void show()
    {

        if (null != component)
        {

            component.show();
        }
    }
}