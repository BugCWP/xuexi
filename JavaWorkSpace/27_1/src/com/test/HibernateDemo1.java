package com.test;

import com.model.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class HibernateDemo1 {
    @Test
    public void test1(){
        Configuration cfg=new Configuration();
        cfg.configure();
        SessionFactory factory=cfg.buildSessionFactory();
        Session session=factory.openSession();
        Transaction tx=session.beginTransaction();
        Customer c=new Customer();
        c.setCustName("客户01");
        session.save(c);
        tx.commit();
        session.clear();
        factory.close();
    }
}
