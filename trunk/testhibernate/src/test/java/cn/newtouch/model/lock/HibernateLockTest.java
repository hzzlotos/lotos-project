package cn.newtouch.model.lock;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class HibernateLockTest
{
    private static SessionFactory sf;

    @BeforeClass
    public static void beforeClass()
    {
        sf = new AnnotationConfiguration().configure().buildSessionFactory();
    }

    @AfterClass
    public static void afterClass()
    {
        sf.close();
    }

    @Test
    public void testSchemaExport()
    {
        new SchemaExport(new AnnotationConfiguration().configure()).create(
                false, true);
    }

    @Test
    public void testSave()
    {
        Session session = sf.openSession();
        session.beginTransaction();

        Account a = new Account();
        a.setBalance(100);
        session.save(a);

        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void testOptimisticLock()
    {
        Session session = sf.openSession();

        Session session2 = sf.openSession();

        session.beginTransaction();
        Account a1 = (Account) session.get(Account.class, 1);

        session2.beginTransaction();
        Account a2 = (Account) session2.get(Account.class, 1);

        a1.setBalance(a1.getBalance() + 10);
        session.save(a1);
        a2.setBalance(1100);
        session.save(a1);

        session.getTransaction().commit();
        System.out.println(a1.getVersion());
        session.close();
        session2.getTransaction().commit();
        System.out.println(a2.getVersion());

        session2.close();
    }

    public static void main(String[] args)
    {
        beforeClass();
    }
}
