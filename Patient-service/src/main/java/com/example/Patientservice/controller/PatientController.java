package com.example.Patientservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.Patientservice.dto.PatientDto;
import com.example.Patientservice.service.PatientService;

@RestController
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping("/patients")
    public List<PatientDto> getAllPatients() {
        return patientService.getAllPatients();
    }

    @GetMapping("/patients/{id}")
    public Optional<PatientDto> getPatientById(@PathVariable String id) {
        return patientService.getPatientById(id);
    }

    @PostMapping("/patients")
    public void addPatient(@RequestBody PatientDto patient) {
        patientService.addPatient(patient);
    }

    @PutMapping("/patients/{id}")
    public void updatePatient(@PathVariable String id, @RequestBody PatientDto updatedPatient) {
        patientService.updatePatient(id, updatedPatient);
    }

    @DeleteMapping("/patients/{id}")
    public void deletePatientById(@PathVariable String id) {
        patientService.deletePatientById(id);
    }
}
