package org.hibernatetutorials;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernatetutorials.pojo.Student;


/*
    Steps to save the database using hibernate
    1. Create a xml file in resource and add the hibernate configurations into it
        - Need to add below configurations
           - Properties like
                hibernate.connection.driver_class - com.mysql.cj.jdbc.Driver ,
                hibernate.connection.url - jdbc:mysql://localhost:3306/hibernate ,
                hibernate.connection.username - root,
                hibernate.connection.password - Sahil28,
                hibernate.connection.dialect - org.hibernate.dialect.MySQLDialect,
                hibernate.hbm2ddl.auto - update  (This is the optional property which is used to create, insert, drop table in database without manually creating it)
                show_sql - true (This is used to show the sql query into console/terminal)
           - hibernate.cfg.xml sample file
                <?xml version='1.0' encoding='utf-8'?>
                <!DOCTYPE hibernate-configuration PUBLIC
                        "-//Hibernate/Hibernate Configuration DTD 3.0//EN"
                        "http://www.hibernate.org/dtd/hibernate-configuration-3.0.dtd">
                <hibernate-configuration>
                    <session-factory>
                        <!-- Database connection settings -->
                        <property name="hibernate.connection.driver_class">com.mysql.cj.jdbc.Driver</property>
                        <property name="hibernate.connection.url">jdbc:mysql://localhost:3306/hibernate</property>
                        <property name="hibernate.connection.username">root</property>
                        <property name="hibernate.connection.password">Sahil28</property>
                        <!-- JDBC dialect -->
                        <property name="hibernate.dialect">org.hibernate.dialect.MySQLDialect</property>
                        <!-- Schema generation -->
                        <property name="hibernate.hbm2ddl.auto">update</property>
                        <!-- Logging -->
                        <property name="show_sql">true</property>
                        <property name="format_sql">true</property>
                    </session-factory>
                </hibernate-configuration>
    2. Create an object of Configuration class and configure the xml using configure() method.
    3. Also can add the annotated class means a table prototype using addAnnotatedClass() method and also it can be defined into the xml file.
    4. Create an object of session
        - for this we need an object of SessionFactory and the buildSessionFactory method of Configuration class is used . Note that create the instance once per database application cause it consumes a lot of resources.
        - After making the object of SessionFactory create an instance of Session .And this instance will be useful for making the changes into DB.
        - After saving the data commit the changes into the DB cause it necessary to reflect the changes into the DB.
 */
public class SaveTheData {
    public static void main(String[] args) {
        // Created the object of student entity and added the necessary information for that entity
        Student student = new Student();
        student.setRoll_no(3);
        student.setAge(1);
        student.setName("Sahil");

        // Created object of Configuration class and configured the XML in which all the validation related to DB are stored
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        // Added/Registered the annotated class student into configuration
        configuration.addAnnotatedClass(Student.class);

        // SessionFactory is an interface which is used to build a factory and should create one instance per database application cause it consumes a lot of resources.
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        // Session is an interface  which is used to make CRUD operation on DB. And we can create a number of session
        Session session = null;

        // Open a session / create a session which used to store, delete data using openSession() method of session factory.
        session = sessionFactory.openSession();

        // Transaction is used to make transaction into the DB


        Transaction transaction = session.beginTransaction();
        session.persist(student);
        transaction.commit();



    }
}