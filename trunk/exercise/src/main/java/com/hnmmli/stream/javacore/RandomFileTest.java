package com.hnmmli.stream.javacore;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class RandomFileTest
{
    public static void main(String[] args)
    {
        Employee[] staff = new Employee[3];

        staff[0] = new Employee("Carl Cracker", 75000, 1987, 12, 15);
        staff[1] = new Employee("Harry Hacker", 50000, 1989, 10, 1);
        staff[2] = new Employee("Tony Tester", 40000, 1990, 3, 15);

        try
        {
            // save all employee records to the file employee.dat
            DataOutputStream out = new DataOutputStream(new FileOutputStream("employee.dat"));// 写在了项目的根目录
            for (Employee e : staff)
            {
                e.writeData(out);
            }
            out.close();

            // retrieve all records into a new array
            RandomAccessFile in = new RandomAccessFile("employee.dat", "r"); // 传入文件名和读取方式
            // compute the array size
            int n = (int) (in.length() / Employee.RECORD_SIZE);// 得到文件的存储多少记录
            Employee[] newStaff = new Employee[n];// 实例化数组

            // read employees in reverse order
            for (int i = n - 1; i >= 0; i--)// 倒序输入
            // for (int i = 0; i < n; i++)
            {
                newStaff[i] = new Employee();// 实例化
                in.seek(i * Employee.RECORD_SIZE);// 将文件指针移到正确的位置
                newStaff[i].readData(in);
            }
            in.close();

            // print the newly read employee records
            for (Employee e : newStaff)
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

class DataIO// 定长字符串写入的读出
{
    public static String readFixedString(int size, DataInput in) throws IOException
    {
        StringBuilder b = new StringBuilder(size);
        int i = 0;
        boolean more = true;
        while (more && i < size)
        {
            char ch = in.readChar();
            i++;
            if (ch == 0)
            {
                more = false;
            }
            else
            {
                b.append(ch);
            }
        }
        in.skipBytes(2 * (size - i));
        return b.toString();
    }

    public static void writeFixedString(String s, int size, DataOutput out) throws IOException
    {
        for (int i = 0; i < size; i++)
        {
            char ch = 0;
            if (i < s.length())
            {
                ch = s.charAt(i);
            }
            out.writeChar(ch);
        }
        // 共80个字符
    }
}

class Employee
{
    public static final int NAME_SIZE   = 40;

    public static final int RECORD_SIZE = 2 * NAME_SIZE + 8 + 4 + 4 + 4;

    private Date            hireDay;

    private String          name;

    private double          salary;

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

    /**
     * Raises the salary of this employee.
     * 
     * @byPercent the percentage of the raise
     */
    public void raiseSalary(double byPercent)
    {
        double raise = this.salary * byPercent / 100;
        this.salary += raise;
    }

    /**
     * Reads employee data from a data input
     * 
     * @param in the data input
     */
    public void readData(DataInput in) throws IOException// 定长数据读出
    {
        this.name = DataIO.readFixedString(NAME_SIZE, in);
        this.salary = in.readDouble();
        int y = in.readInt();
        int m = in.readInt();
        int d = in.readInt();
        GregorianCalendar calendar = new GregorianCalendar(y, m - 1, d);
        this.hireDay = calendar.getTime();
    }

    @Override
    public String toString()
    {
        return this.getClass().getName() + "[name=" + this.name + ",salary=" + this.salary + ",hireDay=" + this.hireDay
                + "]";
    }

    /**
     * Writes employee data to a data output
     * 
     * @param out the data output
     */
    public void writeData(DataOutput out) throws IOException
    {
        DataIO.writeFixedString(this.name, NAME_SIZE, out);
        out.writeDouble(this.salary);
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(this.hireDay);
        out.writeInt(calendar.get(Calendar.YEAR));
        out.writeInt(calendar.get(Calendar.MONTH) + 1);
        out.writeInt(calendar.get(Calendar.DAY_OF_MONTH));
    }
}