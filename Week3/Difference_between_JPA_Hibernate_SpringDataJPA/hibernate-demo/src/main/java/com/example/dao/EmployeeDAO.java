package com.example.dao;

import com.example.model.Employee;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class EmployeeDAO {
    private SessionFactory factory;

    public EmployeeDAO() {
        factory = new Configuration().configure().buildSessionFactory();
    }

    public void addEmployee(Employee emp) {
        Transaction tx = null;
        try (Session session = factory.openSession()) {
            tx = session.beginTransaction();
            session.save(emp);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }
}
