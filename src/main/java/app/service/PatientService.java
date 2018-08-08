package app.service;

import app.dao.PatientDAO;
import app.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service("patientService")
public class PatientService {

    @Autowired
    PatientDAO patientDao;

    @Transactional
    public List<Patient> getAllPatients() {
        return patientDao.getAllPatients();
    }

    @Transactional
    public Patient getPatient(int id) {
        return patientDao.getPatient(id);
    }

    @Transactional
    public void addPatient(Patient patient) {
        patientDao.addPatient(patient);
    }

    @Transactional
    public void updatePatient(Patient patient) {
        patientDao.updatePatient(patient);

    }

    @Transactional
    public void deletePatient(int id) {
        patientDao.deletePatient(id);
    }


}
