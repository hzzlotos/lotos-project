package javacore.security.online;

public class LocalFileClassLoaderTest
{
    public static void main(String[] args)
    {
        LocalFileClassLoader classLoader = new LocalFileClassLoader("G:\\eclipse\\workspace\\exercise\\target\\classes");
        try
        {
            Class<?> employeeCls = classLoader.loadClass("javacore.security.online.EmployeeImpl");
            Employee e1 = (Employee) employeeCls.newInstance();
            e1.setFirstName("Levin");
            e1.setLastName("Ding");
            e1.printFullName();
            System.out.println("-----------------------------");
            System.out.println("classLoader===        " + classLoader);
            System.out.println("classLoader parent=== " + classLoader.getParent());
            System.out.println("app classLoader===    " + ClassLoader.getSystemClassLoader());
            System.out.println("-----------------------------");
            Employee e2 = new EmployeeImpl();
            e2.setFirstName("Levin");
            e2.setLastName("Ding");
            System.out.println("e1====" + e1);
            System.out.println("e2====" + e2);
            System.out.println("-----------------------------");
            System.out.println("e1==classLoader==" + e1.getClass().getClassLoader());
            System.out.println("e2==classLoader==" + e2.getClass().getClassLoader());
            System.out.println("-----------------------------");
            System.out.println(e1.equals(e2));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
