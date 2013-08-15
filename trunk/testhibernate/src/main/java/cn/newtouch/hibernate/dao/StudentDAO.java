//-------------------------------------------------------------------------
// Copyright (c) 2000-2010 Digital. All Rights Reserved.
//
// This software is the confidential and proprietary information of
// Digital
//
// Original author: zzHe
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
package cn.newtouch.hibernate.dao;

import java.util.HashMap;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import cn.newtouch.hibernate.util.HibernateUtil;
import cn.newtouch.model.Student;

public class StudentDAO
{
    // 获取时间
    public static void main(String[] args)
    {
        try
        {
            Session session = HibernateUtil.getSession();
            String hql = " from Student";
            List<Student> userList = session.createQuery(hql).list();
            System.out.println("=====1=======" + userList.size());
            Criteria criteria = session.createCriteria(Student.class);
            // 等于
            criteria.add(Restrictions.eq("name", "HZZ"));
            // map中多个属性值
            criteria.add(Restrictions.allEq(new HashMap<String, String>()));
            // 大于
            criteria.add(Restrictions.gt("id", new Long(1)));
            // 大于等于
            criteria.add(Restrictions.ge("id", new Long(1)));
            // 小于
            criteria.add(Restrictions.lt("id", new Long(1)));
            // 小于等于
            criteria.add(Restrictions.le("id", new Long(1)));
            // 介于xxx与yyy之间
            criteria.add(Restrictions.between("id", new Long(1), new Long(2)));
            // 包含
            criteria.add(Restrictions.like("name", "H"));
            // and关系组合
            criteria.add(Restrictions.and(Restrictions.ge("id", new Long(1)),
                    Restrictions.ge("id", new Long(1))));
            // or关系组合
            criteria.add(Restrictions.or(Restrictions.ge("id", new Long(1)),
                    Restrictions.ge("id", new Long(1))));
            userList = criteria.list();
            System.out.println("=====2=======" + userList.size());
            Student student = new Student();
            student.setId(123456L);
            student.setName("hzz");
            student.setAge(14);
            save(student);

            System.out.println("OK!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

        }
        catch (Exception e)
        {
            e.printStackTrace();

        }
    }

    static void save(Student student)
    {
        Session session = null;
        Transaction ts = null;
        try
        {
            session = HibernateUtil.getSession();
            ts = session.beginTransaction();
            session.save(student);
            ts.commit();
        }
        catch (HibernateException e)
        {
            if (null != ts)
            {
                ts.rollback();
            }
            throw e;
        }
        finally
        {
            if (null != session)
            {
                session.close();
            }
        }
    }
}
