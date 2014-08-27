package com.hnmmli.stream.javacore;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;
import java.util.GregorianCalendar;

public class ObjectStreamTest
{
    public static void main(String[] args)
    {
        Manager boss = new Manager("Carl Cracker", 80000, 1987, 12, 15);
        boss.setBonus(5000);

        Employee1[] staff = new Employee1[3];

        staff[0] = boss;
        staff[1] = new Employee1("Harry Hacker", 50000, 1989, 10, 1);
        staff[2] = new Employee1("Tony Tester", 40000, 1990, 3, 15);

        try
        {
            // save all employee records to the file employee.dat
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("employee.dat"));
            out.writeObject(staff);
            out.close();

            // retrieve all records into a new array
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("employee.dat"));
            Employee1[] newStaff = (Employee1[]) in.readObject();
            in.close();

            // print the newly read employee records
            for (Employee1 e : newStaff)
            {
                System.out.println(e);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}

class Employee1 implements Serializable
{
    public Employee1()
    {
    }

    public Employee1(String n, double s, int year, int month, int day)
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

class Manager extends Employee1
{
    /**
     * @param n the employee's name
     * @param s the salary
     * @param year the hire year
     * @param month the hire month
     * @param day the hire day
     */
    public Manager(String n, double s, int year, int month, int day)
    {
        super(n, s, year, month, day);
        this.bonus = 0;
    }

    @Override
    public double getSalary()
    {
        double baseSalary = super.getSalary();
        return baseSalary + this.bonus;
    }

    public void setBonus(double b)
    {
        this.bonus = b;
    }

    @Override
    public String toString()
    {
        return super.toString() + "[bonus=" + this.bonus + "]";
    }

    private double bonus;
}