package com.sihatech.mspatient.mspatient.service;

import com.sihatech.mspatient.mspatient.data.Patient;
import com.sihatech.mspatient.mspatient.repository.PatientRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.UUID;

@Slf4j
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
    public Patient addNewPatient(Patient patient) {
        return  patientRepository.save(patient);
    }

    @Override
    public void deletePatient(UUID patientId) {

    }

    @Override
    public Patient updatePatient(UUID patientId,Patient patient) {
        //Patient patientToUpdate=
        return patientRepository.findById(patientId).map(patientToUpdate -> {
            patientToUpdate.setFirstName(patient.getFirstName());
            patientToUpdate.setLastName(patient.getLastName());
            patientToUpdate.setDateOfBirth(patientToUpdate.getDateOfBirth());
            patientToUpdate.setSocialSecurityNumber(patient.getSocialSecurityNumber());
            log.info("update existing patient");
            return patientRepository.save(patientToUpdate);
        })
                .orElseGet(() -> {
                    patient.setId(patientId);
                    log.info("save new patient");
                    return patientRepository.save(patient);
                });


    }
}
