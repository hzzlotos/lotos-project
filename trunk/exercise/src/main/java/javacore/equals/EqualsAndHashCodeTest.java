package javacore.equals;

public class EqualsAndHashCodeTest
{

    public static void main(String[] args)
    {
        PerfectEqualsAndHashCode aaa = new PerfectEqualsAndHashCode(11L);
        PerfectEqualsAndHashCode bbb = new PerfectEqualsAndHashCode(11L);
        PerfectEqualsAndHashCode ccc = new PerfectEqualsAndHashCode(12L);
        System.out.println(aaa.hashCode());
        System.out.println(bbb.hashCode());
        System.out.println(ccc.hashCode());
        System.out.println("===================================");
        // ==比较的时候使用的不是hashcode()来比较的
        System.out.println(aaa == bbb);
        System.out.println(aaa == ccc);
        System.out.println("===================================");
        System.out.println(aaa.equals(bbb));
        System.out.println(aaa.equals(ccc));
    }

}

class PerfectEqualsAndHashCode
{
    private Long id;

    public PerfectEqualsAndHashCode(Long id)
    {
        this.id = id;
    }

    @Override
    public int hashCode()
    {
        return this.getClass().hashCode() + this.id.hashCode();
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (null == obj)
        {
            return false;
        }
        if (this.getClass() != obj.getClass())
        {
            return false;
        }
        PerfectEqualsAndHashCode temp = (PerfectEqualsAndHashCode) obj;
        if (this.id.equals(temp.id))
        {
            return true;
        }
        return false;
    }
}