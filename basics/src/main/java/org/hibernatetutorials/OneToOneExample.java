package org.hibernatetutorials;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernatetutorials.pojo.Alien;
import org.hibernatetutorials.pojo.Laptop;

public class OneToOneExample {
    public static void main(String []args){
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(org.hibernatetutorials.pojo.Alien.class)
                .addAnnotatedClass(org.hibernatetutorials.pojo.Laptop.class)
                .buildSessionFactory();

        Session session = sessionFactory.openSession();

        Laptop  laptop = new Laptop();
        laptop.setName("Laptop 1");
        laptop.setRam(8);
        laptop.setId(1);

        Alien alien = new Alien();
        alien.setId(1);
        alien.setName("alien");
        alien.setDescription("Alien has a laptop");
        alien.setLaptop(laptop);

        session.persist(laptop);
        session.persist(alien);

        Transaction transaction = session.beginTransaction();

        transaction.commit();

        session.close();
    }
}
