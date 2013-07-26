package cn.newtouch.base.container;

public class Count3Quit2
{
    public static void main(String[] args)
    {
        LinkList<Integer> ll = new LinkList<Integer>();
        LickListObj llo = new LickListObj();

        for (int i = 0; i < 5; i++)
        {
            llo = new LickListObj();
            llo.setNow(i + 1);
            ll.add(llo);
        }
        int countNum = 0;
        llo = ll.getFirst();
        while (ll.getLength() > 1)
        {
            countNum++;
            if (countNum == 3)
            {
                countNum = 0;
                ll.delete(llo);
            }
            llo = llo.getRight();
        }

        System.out.println(ll.getFirst().getNow());
    }
}