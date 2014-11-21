package javacore.stream.javacore;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;
import java.util.GregorianCalendar;

public class SerialCloneTest
{
    public static void main(String[] args)
    {
        Employee2 harry = new Employee2("Harry Hacker", 35000, 1989, 10, 1);
        // clone harry
        Employee2 harry2 = (Employee2) harry.clone();

        // mutate harry
        // harry.raiseSalary(10);

        // now harry and the clone are different
        System.out.println(harry);
        System.out.println(harry2);

        System.out.println("==============================");
        harry.raiseSalary(10);

        // now harry and the clone are different
        System.out.println(harry);
        System.out.println(harry2);
    }
}

/**
 * A class whose clone method uses serialization.
 */
class SerialCloneable implements Cloneable, Serializable
{
    @Override
    public Object clone()
    {
        try
        {
            // save the object to a byte array
            ByteArrayOutputStream bout = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(bout);
            out.writeObject(this);
            out.close();

            // read a clone of the object from the byte array
            ByteArrayInputStream bin = new ByteArrayInputStream(bout.toByteArray());
            ObjectInputStream in = new ObjectInputStream(bin);
            Object ret = in.readObject();
            in.close();

            return ret;
        }
        catch (Exception e)
        {
            return null;
        }
    }
}

/**
 * The familiar Employee2 class, redefined to extend the
 * SerialCloneable class.
 */
class Employee2 extends SerialCloneable
{
    public Employee2(String n, double s, int year, int month, int day)
    {
        this.name = n;
        this.salary = s;
        GregorianCalendar calendar = new GregorianCalendar(year, month - 1, day);
        this.hireDay = calendar.getTime();
    }

    public String getName()
    {
        return this.name;
    }

    public double getSalary()
    {
        return this.salary;
    }

    public Date getHireDay()
    {
        return this.hireDay;
    }

    public void raiseSalary(double byPercent)
    {
        double raise = this.salary * byPercent / 100;
        this.salary += raise;
    }

    @Override
    public String toString()
    {
        return this.getClass().getName() + "[name=" + this.name + ",salary=" + this.salary + ",hireDay=" + this.hireDay
                + "]";
    }

    private String name;

    private double salary;

    private Date   hireDay;
}