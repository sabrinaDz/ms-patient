package com.sihatech.mspatient.mspatient.web.bootstrap;

import com.sihatech.mspatient.mspatient.data.Patient;
import com.sihatech.mspatient.mspatient.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Month;
import java.util.UUID;



@RequiredArgsConstructor
@Component
public class PatientLoader implements CommandLineRunner {

    public static final UUID PATIENT1_UUID= UUID.fromString("d8888e11-c667-42da-b0d5-8e28e05670bb");
    public static final UUID PATIENT2_UUID= UUID.fromString("4869a849-cc02-4468-9e29-d9acb666ad2e");
    public static final UUID PATIENT3_UUID= UUID.fromString("7788068f-8854-43c8-b5cc-93866664bb80");
    public static final UUID PATIENT4_UUID= UUID.fromString("c45994ac-2974-4cc9-a13f-7c6ae75a5d13");
    public static final UUID PATIENT5_UUID= UUID.fromString("16b7b37c-5372-4a23-95f8-0e1c4b3095f3");

    private final PatientRepository patientRepository;




    @Override
    public void run(String... args) throws Exception {

        if(patientRepository.count() == 0 ) {
            loadPatientsObjects();
        }
    }

    private void loadPatientsObjects() {
        Patient patient1=Patient.builder().id(PATIENT1_UUID)
                .firstName("sabrina2")
                .lastName("sahli2")
                .dateOfBirth(LocalDate.of(1988, Month.FEBRUARY,2))
                .socialSecurityNumber (177777777777723L)
                .weight(73.5)
                .size(1.61)
                .build();

        Patient patient2=Patient.builder().id(PATIENT2_UUID)
                .firstName("sabrina2")
                .lastName("sahli2")
                .dateOfBirth(LocalDate.of(1988, Month.FEBRUARY,2))
                .socialSecurityNumber (177777777777723L)
                .weight(73.5)
                .size(1.61)
                .build();

        Patient patient3=Patient.builder().id(PATIENT3_UUID)
                .firstName("sabrina2")
                .lastName("sahli2")
                .dateOfBirth(LocalDate.of(1988, Month.FEBRUARY,2))
                .socialSecurityNumber (177777777777723L)
                .weight(73.5)
                .size(1.61)
                .build();

        Patient patient4=Patient.builder().id(PATIENT4_UUID)
                .firstName("sabrina2")
                .lastName("sahli2")
                .dateOfBirth(LocalDate.of(1988, Month.FEBRUARY,2))
                .socialSecurityNumber (177777777777723L)
                .weight(73.5)
                .size(1.61)
                .build();
        patientRepository.save(patient1);
        patientRepository.save(patient2);
        patientRepository.save(patient3);
        patientRepository.save(patient4);
    }


}