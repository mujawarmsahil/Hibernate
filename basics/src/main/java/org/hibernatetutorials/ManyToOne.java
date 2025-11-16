package org.hibernatetutorials;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernatetutorials.pojo.Doctor;
import org.hibernatetutorials.pojo.Patient;

import java.util.Arrays;

public class ManyToOne {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure()
                .addAnnotatedClass(org.hibernatetutorials.pojo.Doctor.class)
                .addAnnotatedClass(org.hibernatetutorials.pojo.Patient.class)
                .buildSessionFactory();

        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();

        Patient patient = new Patient();
        patient.setId(1);
        patient.setName("Patient 1");

        Patient patient2 = new Patient();
        patient2.setId(2);
        patient2.setName("Patient 2");

        Patient patient3 = new Patient();
        patient3.setId(3);
        patient3.setName("Patient 3");

        Doctor doctor = new Doctor();
        doctor.setId(1);
        doctor.setName("Doctor 1");
        doctor.setSpecialty("Skin");
        doctor.setPatientList(Arrays.asList(patient,patient2,patient3));

        patient.setDoctor(doctor);
        patient2.setDoctor(doctor);
        patient3.setDoctor(doctor);


        session.persist(doctor);
        session.persist(patient2);
        session.persist(patient);
        session.persist(patient3);

        transaction.commit();
        session.close();
    }
}
