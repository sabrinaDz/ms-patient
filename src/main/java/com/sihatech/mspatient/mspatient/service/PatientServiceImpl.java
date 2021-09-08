package com.sihatech.mspatient.mspatient.service;

import com.sihatech.mspatient.mspatient.data.Patient;
import com.sihatech.mspatient.mspatient.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.UUID;

@Service
public class PatientServiceImpl implements PatientService{


    private final PatientRepository patientRepository;

    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }


    @Override
    public List<Patient> listPatients() {
        return patientRepository.findAll();
    }

    @Override
    public Patient getPatientById(UUID patientId) {
        Patient patient = patientRepository.getById(patientId);
        return Patient.builder().id(patient.getId())
                .firstName(patient.getFirstName())
                .lastName(patient.getLastName())
                .dateOfBirth(patient.getDateOfBirth())
                .socialSecurityNumber(patient.getSocialSecurityNumber())
                .weight(patient.getWeight())
                .size(patient.getSize())
                .build();
    }

    @Override
    public Patient addNewPatient(UUID patientId) {
        return null;
    }

    @Override
    public void deletePatient(UUID patientId) {

    }

    @Override
    public Patient updatePatient(Patient patient) {
        return null;
    }
}
