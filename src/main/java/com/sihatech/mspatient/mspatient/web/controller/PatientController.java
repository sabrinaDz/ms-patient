package com.sihatech.mspatient.mspatient.web.controller;

import com.sihatech.mspatient.mspatient.data.Patient;
import com.sihatech.mspatient.mspatient.service.PatientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/patients")
public class PatientController {


    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }



    @GetMapping("/list")
    public ResponseEntity<List<Patient>> patientList(){

        return new ResponseEntity<>(patientService.listPatients(), HttpStatus.OK);
    }



}
