package net.newtouch.clone;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class DeepCloneTest
{
    public static void main(String[] args)
    {
        // cache();
        disk();
    }

    private static void cache()
    {
        Teacher t = new Teacher("zhanglaoshi", 27);
        Student s = new Student("xiaozhang", 17, t);
        Student sClone = s.deepClone();
        System.out.println("===s.hashcode=" + s.hashCode());
        System.out.println("===sClone.hashcode=" + sClone.hashCode());
        System.out.println("=========================================");
        System.out.println("===s.name=" + s.getName());
        System.out.println("===sClone.name=" + sClone.getName());
        System.out.println("=========================================");
        System.out.println("===s.age=" + s.getAge());
        System.out.println("===sClone.age=" + sClone.getAge());
        System.out.println("=========================================");
        System.out.println("===s.t.hashcode=" + s.getTeacher().hashCode());
        System.out.println("===sClone.t.hashcode=" + sClone.getTeacher().hashCode());
        System.out.println("=========================================");
        System.out.println("===s.t.name=" + s.getTeacher().getName());
        System.out.println("===sClone.t.name=" + sClone.getTeacher().getName());
        System.out.println("=========================================");
        System.out.println("===s.t.age=" + s.getTeacher().getAge());
        System.out.println("===sClone.t.age=" + sClone.getTeacher().getAge());
    }

    private static void disk()
    {
        Teacher t = new Teacher("zhanglaoshi", 27);
        Student s = new Student("xiaozhang", 17, t);
        try
        {
            File f = new File("E:/test/serializable/user.tmp");
            if (f.exists())
            {
                f.delete();
            }
            writeObject(s, f);
            Student student = (Student) readObject(f);
            System.out.println(student.getName());
            System.out.println(student.getAge());
            System.out.println(student.getTeacher().getName());
            System.out.println(student.getTeacher().getAge());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * 
     * 将对象序列化到磁盘文件中
     * 
     * @paramo
     * 
     * @throwsException
     */

    public static void writeObject(Object o, File f) throws Exception
    {
        FileOutputStream os = new FileOutputStream(f);
        ObjectOutputStream oos = new ObjectOutputStream(os);
        oos.writeObject(o);
        oos.close();
        os.close();
        System.out.println("===============================end");

    }

    /**
     * 
     * 反序列化,将磁盘文件转化为对象
     * 
     * @paramf
     * 
     * @return
     * 
     * @throwsException
     */

    public static Object readObject(File f) throws Exception
    {

        InputStream is = new FileInputStream(f);
        ObjectInputStream ois = new ObjectInputStream(is);
        System.out.println("===============================end");
        return ois.readObject();

    }
}

class Teacher implements Serializable
{
    private static final long serialVersionUID = 1L;

    private String            name;

    private int               age;

    public Teacher(String name, int age)
    {
        this.name = name;
        this.age = age;
    }

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getAge()
    {
        return this.age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

}

class Student implements Serializable
{
    private static final long serialVersionUID = 1L;

    private String            name;

    private int               age;

    private Teacher           teacher;

    public Student(String name, int age, Teacher teacher)
    {
        this.name = name;
        this.age = age;
        this.teacher = teacher;
    }

    public Teacher getTeacher()
    {
        return this.teacher;
    }

    public void setTeacher(Teacher teacher)
    {
        this.teacher = teacher;
    }

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getAge()
    {
        return this.age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public Student deepClone()
    {
        try
        {
            // 序列化 需要使用ByteArray系列Stream
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(this);
            // 反序列化
            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bis);
            return (Student) ois.readObject();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
}