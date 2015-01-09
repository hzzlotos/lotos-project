package javacore.stream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializableTest
{
    public static void main(String[] args)
    {
        try
        {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("employee.dat"));
            Employee e1 = new Employee("hzz", 13000D, 1984, 2, 9);
            Employee e2 = new Employee("aaa", 100D, 2014, 6, 6);
            oos.writeObject(e1);
            oos.writeObject(e2);
            oos.close();

            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("employee.dat"));
            Employee e3 = (Employee) ois.readObject();
            Employee e4 = (Employee) ois.readObject();
            ois.close();
            System.out.println(e1);
            System.out.println(e2);
            System.out.println(e3);
            System.out.println(e4);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}