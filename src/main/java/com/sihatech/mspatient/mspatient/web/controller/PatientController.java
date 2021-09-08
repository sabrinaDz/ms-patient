package com.sihatech.mspatient.mspatient.web.controller;

import com.sihatech.mspatient.mspatient.data.Patient;
import com.sihatech.mspatient.mspatient.service.PatientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

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


    @GetMapping({"/{patientId}"})
    public ResponseEntity<Patient> getPatientById(@PathVariable("patientId") UUID patientId) {
        return new ResponseEntity<>(patientService.getPatientById(patientId), HttpStatus.OK);
    }


}
