package com.sihatech.mspatient.mspatient.service;

import com.sihatech.mspatient.mspatient.data.Patient;

import java.util.List;
import java.util.UUID;

public interface PatientService {

    List<Patient> listPatients();

    Patient getPatientById(UUID patientId);

    Patient addNewPatient(UUID patientId);

    void deletePatient(UUID patientId);

    Patient updatePatient(Patient patient);
}
