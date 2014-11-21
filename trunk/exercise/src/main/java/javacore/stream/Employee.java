package javacore.stream;

import java.io.Serializable;
import java.util.Date;
import java.util.GregorianCalendar;

public class Employee implements Serializable
{

    private static final long serialVersionUID = 1L;

    private Date              hireDay;

    private String            name;

    private double            salary;

    public Employee()
    {
    }

    public Employee(String n, double s, int year, int month, int day)
    {
        this.name = n;
        this.salary = s;
        GregorianCalendar calendar = new GregorianCalendar(year, month - 1, day);
        this.hireDay = calendar.getTime();
    }

    public Date getHireDay()
    {
        return this.hireDay;
    }

    public String getName()
    {
        return this.name;
    }

    public double getSalary()
    {
        return this.salary;
    }

    public void raiseSalary(double byPercent)
    {
        double raise = this.salary * byPercent / 100;
        this.salary += raise;
    }

    @Override
    public String toString()
    {
        return "===" + super.hashCode() + "===" + this.getClass().getName() + "[name=" + this.name + ",salary="
                + this.salary + ",hireDay=" + this.hireDay + "]";
    }
}