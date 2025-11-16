package org.hibernatetutorials;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernatetutorials.pojo.App;
import org.hibernatetutorials.pojo.User;

import java.util.Arrays;

public class ManyToMany {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure()
                .addAnnotatedClass(App.class)
                .addAnnotatedClass(User.class)
                .buildSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        App instagram = new App();
        instagram.setName("Instagram");
        instagram.setId(0);

        App facebook = new App();
        facebook.setName("Facebook");
        facebook.setId(1);

        App whatsapp = new App();
        whatsapp.setName("Whatsapp");
        whatsapp.setId(2);

        User sahil = new User();
        sahil.setName("sahil");
        sahil.setId(0);

        User sajid =  new User();
        sajid.setName("sajid");
        sajid.setId(1);

        User shruti = new User();
        shruti.setName("shruti");
        shruti.setId(2);

        User suhana =  new User();
        suhana.setName("suhana");
        suhana.setId(3);

        suhana.setApps(Arrays.asList(instagram,facebook,whatsapp));
        shruti.setApps(Arrays.asList(whatsapp,instagram));
        sajid.setApps(Arrays.asList(whatsapp));
        sahil.setApps(Arrays.asList(instagram,whatsapp));

        instagram.setUsers(Arrays.asList(suhana,sahil,shruti));
        whatsapp.setUsers(Arrays.asList(suhana,sajid,sahil,shruti));
        facebook.setUsers(Arrays.asList(suhana));

        session.persist(instagram);
        session.persist(whatsapp);
        session.persist(facebook);

        session.persist(sajid);
        session.persist(suhana);
        session.persist(shruti);
        session.persist(sahil);

        transaction.commit();
        session.close();
    }
}
