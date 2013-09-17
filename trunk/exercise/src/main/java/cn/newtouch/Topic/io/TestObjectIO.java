package cn.newtouch.Topic.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class TestObjectIO
{
    public static void main(String args[]) throws Exception
    {
        T t = new T();
        t.k = 8;
        FileOutputStream fos = new FileOutputStream(
                "./src/cn/newtouch/io/testobjectio.dat");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(t);
        oos.flush();
        oos.close();

        FileInputStream fis = new FileInputStream(
                "./src/cn/newtouch/io/testobjectio.dat");
        ObjectInputStream ois = new ObjectInputStream(fis);
        T tReaded = (T) ois.readObject();
        System.out.println("i====" + tReaded.i + " j====" + tReaded.j
                + " d====" + tReaded.d + " k====" + tReaded.k);

    }
}

class T implements Serializable
{
    int           i = 10;

    int           j = 9;

    double        d = 2.3;

    transient int k = 15;
}