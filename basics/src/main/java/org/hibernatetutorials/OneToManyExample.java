package org.hibernatetutorials;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernatetutorials.pojo.School;
import org.hibernatetutorials.pojo.Student;

import java.util.Arrays;

public class OneToManyExample {
    public static void main(String []args){
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(org.hibernatetutorials.pojo.School.class)
                .addAnnotatedClass(org.hibernatetutorials.pojo.Student.class)
                .buildSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Student student = new Student();
        student.setName("Sahil");
        student.setAge(30);
        student.setRoll_no(1);

        Student student2 = new Student();
        student2.setName("Shruti");
        student2.setAge(21);
        student2.setRoll_no(2);

        Student student3 = new Student();
        student3.setName("Sajid");
        student3.setAge(21);
        student3.setRoll_no(3);

        School school = new School();
        school.setId(2);
        school.setAddress("Pune");
        school.setStudents(Arrays.asList(student,student2,student3));


        session.persist(student);
        session.persist(student2);
        session.persist(student3);
        session.persist(school);

        transaction.commit();
        session.close();
        sessionFactory.close();
    }


}
