
package com.klef.fsad.exam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Date;

public class ClientDemo {

    public static void main(String[] args) {

        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        cfg.addAnnotatedClass(Department.class);

        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();

        Transaction tx = session.beginTransaction();

        Department d = new Department("CSE","Computer Science Department","Active", new Date());

        session.save(d);

        tx.commit();

        System.out.println("Department inserted successfully");

        // Delete Example
        Session session2 = factory.openSession();
        Transaction tx2 = session2.beginTransaction();

        Department del = session2.get(Department.class,1);
        if(del!=null){
            session2.delete(del);
            System.out.println("Department deleted");
        }

        tx2.commit();

        session.close();
        factory.close();
    }
}
