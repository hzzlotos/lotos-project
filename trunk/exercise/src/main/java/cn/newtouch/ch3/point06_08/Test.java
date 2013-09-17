package cn.newtouch.ch3.point06_08;

class BirthDate
{
    private int day;

    private int month;

    private int year;

    public BirthDate(int d, int m, int y)
    {
        this.day = d;
        this.month = m;
        this.year = y;
    }

    public void setDay(int d)
    {
        this.day = d;
    }

    public void setMonth(int m)
    {
        this.month = m;
    }

    public void setYear(int y)
    {
        this.year = y;
    }

    public int getDay()
    {
        return this.day;
    }

    public int getMonth()
    {
        return this.month;
    }

    public int getYear()
    {
        return this.year;
    }

    public void display()
    {
        System.out.println(this.day + " - " + this.month + " - " + this.year);
    }
}

public class Test
{
    public static void main(String args[])
    {
        Test test = new Test();
        int date = 9;
        BirthDate d1 = new BirthDate(7, 7, 1970);
        BirthDate d2 = new BirthDate(1, 1, 2000);
        test.change1(date);
        test.change2(d1);
        test.change3(d2);
        System.out.println("date=" + date);
        d1.display();
        d2.display();
    }

    public void change1(int i)
    {
        i = 1234;
    }

    public void change2(BirthDate b)
    {
        b = new BirthDate(22, 2, 2004);
    }

    public void change3(BirthDate b)
    {
        b.setDay(22);
    }
}
