package cn.newtouch.Topic.designpattern.finery;

public class TShirts extends Finery
{

    public TShirts()
    {
    }

    public TShirts(String name)
    {
        super(name);
    }

    @Override
    public void show()
    {

        System.out.println("big Tshirt");
        super.show();
    }
}
