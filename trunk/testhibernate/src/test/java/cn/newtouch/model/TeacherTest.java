//-------------------------------------------------------------------------
// Copyright (c) 2000-2010 Digital. All Rights Reserved.
//
// This software is the confidential and proprietary information of
// Digital
//
// Original author: LoToS
//
//-------------------------------------------------------------------------
// LOOSOFT MAKES NO REPRESENTATIONS OR WARRANTIES ABOUT THE SUITABILITY OF
// THE SOFTWARE, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED
// TO THE IMPLIED WARRANTIES OF MERCHANTABILITY, FITNESS FOR A
// PARTICULAR PURPOSE, OR NON-INFRINGEMENT. UFINITY SHALL NOT BE
// LIABLE FOR ANY DAMAGES SUFFERED BY LICENSEE AS A RESULT OF USING,
// MODIFYING OR DISTRIBUTING THIS SOFTWARE OR ITS DERIVATIVES.
//
// THIS SOFTWARE IS NOT DESIGNED OR INTENDED FOR USE OR RESALE AS ON-LINE
// CONTROL EQUIPMENT IN HAZARDOUS ENVIRONMENTS REQUIRING FAIL-SAFE
// PERFORMANCE, SUCH AS IN THE OPERATION OF NUCLEAR FACILITIES, AIRCRAFT
// NAVIGATION OR COMMUNICATION SYSTEMS, AIR TRAFFIC CONTROL, DIRECT LIFE
// SUPPORT MACHINES, OR WEAPONS SYSTEMS, IN WHICH THE FAILURE OF THE
// SOFTWARE COULD LEAD DIRECTLY TO DEATH, PERSONAL INJURY, OR SEVERE
// PHYSICAL OR ENVIRONMENTAL DAMAGE ("HIGH RISK ACTIVITIES"). UFINITY
// SPECIFICALLY DISCLAIMS ANY EXPRESS OR IMPLIED WARRANTY OF FITNESS FOR
// HIGH RISK ACTIVITIES.
//-------------------------------------------------------------------------
package cn.newtouch.model;

import java.util.Date;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;

import cn.newtouch.hibernate.util.HibernateUtil;

public class TeacherTest
{
    @Test
    public void testTeacherSave()
    {
        Teacher t = new Teacher();
        t.setId(6);
        t.setName("t1");
        t.setTitle("middle");
        t.setBirthDate(new Date());

        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.save(t);
        session.getTransaction().commit();
    }

    @Test
    public void testSaveWith3State()
    {

        Teacher t = new Teacher();

        t.setName("t1");
        t.setTitle("middle");
        t.setBirthDate(new Date());

        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.save(t);
        System.out.println(t.getId());
        session.getTransaction().commit();

        System.out.println(t.getId());
    }

    @Test
    public void testDelete()
    {

        Teacher t = new Teacher();
        t.setName("t1");
        t.setTitle("middle");
        t.setBirthDate(new Date());

        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.save(t);
        System.out.println(t.getId());
        session.getTransaction().commit();

        Session session2 = HibernateUtil.getSession();
        session2.beginTransaction();
        session2.delete(t);
        session2.getTransaction().commit();
    }

    @Test
    public void testDelete2()
    {

        Teacher t = new Teacher();
        t.setId(2);

        Session session2 = HibernateUtil.getSession();
        session2.beginTransaction();
        session2.delete(t);
        session2.getTransaction().commit();
    }

    @Test
    public void testLoad()
    {

        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Teacher t = (Teacher) session.load(Teacher.class, 55);
        System.out.println(t.getName());
        session.getTransaction().commit();
        System.out.println(t.getClass());
        // 
    }

    @Test
    public void testGet()
    {

        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Teacher t = (Teacher) session.get(Teacher.class, 55);

        session.getTransaction().commit();
        System.out.println(t.getClass());
        // System.out.println(t.getName());
    }

    @Test
    public void testUpdate1()
    {

        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Teacher t = (Teacher) session.get(Teacher.class, 1);

        session.getTransaction().commit();

        t.setName("zhanglaoshi");

        Session session2 = HibernateUtil.getSession();
        session2.beginTransaction();
        session2.update(t);

        session2.getTransaction().commit();
    }

    @Test
    public void testUpdate2()
    {

        Teacher t = new Teacher();
        t.setName("zhanglaoshi");

        Session session2 = HibernateUtil.getSession();
        session2.beginTransaction();
        session2.update(t);

        session2.getTransaction().commit();
    }

    @Test
    public void testUpdate3()
    {

        Teacher t = new Teacher();
        t.setId(1);
        t.setName("zhanglaoshi");

        Session session2 = HibernateUtil.getSession();
        session2.beginTransaction();
        session2.update(t);

        session2.getTransaction().commit();
    }

    @Test
    public void testUpdate4()
    {

        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Teacher t = (Teacher) session.get(Teacher.class, 1);
        t.setName("zhangsan2");
        session.getTransaction().commit();
    }

    @Test
    public void testUpdate5()
    {

        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Student s = (Student) session.get(Student.class, 1);
        s.setName("zhangsan5");
        session.getTransaction().commit();

        s.setName("z4");

        Session session2 = HibernateUtil.getSession();
        session2.beginTransaction();
        session2.update(s);
        session2.getTransaction().commit();
    }

    @Test
    public void testUpdate6()
    {

        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Student s = (Student) session.get(Student.class, 1L);
        s.setName("zhangsan6");
        session.getTransaction().commit();

        s.setName("z4");

        Session session2 = HibernateUtil.getSession();
        session2.beginTransaction();
        // 合并
        session2.merge(s);
        session2.getTransaction().commit();
    }

    @Test
    public void testUpdate7()
    {

        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Query q = session
                .createQuery("update Student s set s.name='z5' where s.id = 1");
        q.executeUpdate();
        session.getTransaction().commit();

    }

    @Test
    public void testSaveOrUpdate()
    {

        Teacher t = new Teacher();
        t.setName("t1");
        t.setTitle("middle");
        t.setBirthDate(new Date());

        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.saveOrUpdate(t);

        session.getTransaction().commit();

        t.setName("t2");

        Session session2 = HibernateUtil.getSession();
        session2.beginTransaction();
        session2.saveOrUpdate(t);
        session2.getTransaction().commit();

    }

    @Test
    public void testClear()
    {

        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Teacher t = (Teacher) session.load(Teacher.class, 1);
        System.out.println(t.getName());

        session.clear();

        Teacher t2 = (Teacher) session.load(Teacher.class, 1);
        System.out.println(t2.getName());
        session.getTransaction().commit();

    }

    @Test
    public void testFlush()
    {

        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Teacher t = (Teacher) session.load(Teacher.class, 1);
        t.setName("tttt");

        session.clear();

        t.setName("ttttt");

        session.getTransaction().commit();

    }

    @Test
    public void testSchemaExport()
    {
        // new SchemaExport(new
        // AnnotationConfiguration().configure()).create(false, true);
    }
}
