package app.dao;

import app.model.Patient;

import java.util.List;

public interface PatientDAO {
    public List<Patient> getAllPatients();

    public Patient getPatient(int snils);

    public Patient addPatient(Patient patient);

    public void updatePatient(Patient patient);

    public void deletePatient(int snils);
}
