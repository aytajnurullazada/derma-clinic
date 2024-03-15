package com.example.Patientservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

import com.example.Patientservice.dto.PatientDto;
import com.example.Patientservice.service.PatientService;

@RestController
@RequestMapping("/api")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping("/patients")
    public List<PatientDto> getAllPatients() {
        return patientService.getAllPatients();
    }

    @GetMapping("/patients/{id}")
    public ResponseEntity<PatientDto> getPatientById(@PathVariable String id) {
        Optional<PatientDto> patient = patientService.getPatientById(id);
        return patient.map(ResponseEntity::ok)
                     .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/patients")
    public void addPatient(@RequestBody PatientDto patient) {
        patientService.addPatient(patient);
    }

    @PutMapping("/patients/{id}")
    public void updatePatient(@PathVariable String id, @RequestBody PatientDto updatedPatient) {
        patientService.updatePatient(id, updatedPatient);
    }

    // @DeleteMapping("/patients/{id}")
    // public void deletePatientById(@PathVariable String id) {
    //     patientService.deletePatientById(id);
    // }
}
