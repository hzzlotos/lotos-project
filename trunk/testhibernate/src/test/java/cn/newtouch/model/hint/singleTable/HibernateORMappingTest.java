package cn.newtouch.model.hint.singleTable;

import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.BeforeClass;
import org.junit.Test;

import cn.newtouch.hibernate.util.HibernateUtil;

public class HibernateORMappingTest
{
    private static SessionFactory sessionFactory;

    @BeforeClass
    public static void beforeClass()
    {
        new SchemaExport(new AnnotationConfiguration().configure()).create(false, true);
        sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
    }

    @Test
    public void testSave()
    {
        Student s = new Student();
        s.setName("s1");
        s.setScore(80);
        Teacher t = new Teacher();
        t.setName("t1");
        t.setTitle("中级");

        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.save(s);
        session.save(t);
        session.getTransaction().commit();
        // session.close();
    }

    @Test
    public void testLoad()
    {

        this.testSave();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Student s = (Student) session.load(Student.class, 1, LockMode.UPGRADE);
        System.out.println(s.getScore());
        Person p = (Person) session.load(Person.class, 2);
        System.out.println(p.getName());
        session.getTransaction().commit();
        session.close();

    }

    @Test
    public void testSchemaExport()
    {
        new SchemaExport(new AnnotationConfiguration().configure()).create(false, true);
    }

    public static void main(String[] args)
    {
        // testSave();
    }
}
