package org.hibernatetutorials;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernatetutorials.pojo.Student;

public class DeleteTheData {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();

        Student student = new Student();
        student.setName("suhana");
        student.setAge(21);
        student.setRoll_no(4);

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.remove(student);
        transaction.commit();

        session.close();
        sessionFactory.close();
    }
}
