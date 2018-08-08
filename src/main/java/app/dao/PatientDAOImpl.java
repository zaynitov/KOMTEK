package app.dao;

import app.model.Patient;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PatientDAOImpl implements PatientDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }


    @Override
    public List<Patient> getAllPatients() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Patient> customerList = session.createQuery("from Patient").list();
        return customerList;
    }


    @Override
    public Patient getPatient(int snils) {
        Session session = this.sessionFactory.getCurrentSession();
        Patient patient = (Patient) session.get(Patient.class, snils);
        return patient;
    }

    @Override
    public Patient addPatient(Patient patient) {
        Session session = this.sessionFactory.getCurrentSession();
        session.save(patient);
        return patient;
    }

    @Override
    public void updatePatient(Patient patient) {
        Session session = this.sessionFactory.getCurrentSession();
        Hibernate.initialize(patient);
        session.update(patient);
    }

    @Override
    public void deletePatient(int snils) {
        Session session = this.sessionFactory.getCurrentSession();
        Patient p = (Patient) session.load(Patient.class, new Integer(snils));
        if (null != p) {
            session.delete(p);
        }
    }
}
