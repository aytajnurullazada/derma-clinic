package com.example.Patientservice.controller;

import org.apache.hc.core5.http.HttpStatus;
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
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import com.example.Patientservice.model.PatientModel;
import com.example.Patientservice.repository.PatientRepository;



@RestController
@RequestMapping("/patient")

public class PatientController {

    @Autowired
    private PatientRepository patientRepository;

    @GetMapping("/{id}")
    public ResponseEntity<PatientModel> findById(@PathVariable Integer id) {
        Optional<PatientModel> patientOptional = patientRepository.findById(id);
        if (patientOptional.isPresent()) {
            PatientModel patient = patientOptional.get();
            return ResponseEntity.ok(patient);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @GetMapping("/all")
    public List<PatientModel> getAllPatients() {
        Iterable<PatientModel> patientsIterable = patientRepository.findAll();
        List<PatientModel> patientList = StreamSupport.stream(patientsIterable.spliterator(), false)
                                        .collect(Collectors.toList());
        return patientList;
    }

    @PostMapping("/add")
    public ResponseEntity<PatientModel> createPatient(@RequestBody PatientModel patient) {
        PatientModel savedPatient = patientRepository.save(patient);
        return ResponseEntity.status(HttpStatus.SC_CREATED).body(savedPatient);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<PatientModel> updatePatient(@PathVariable Integer id, @RequestBody PatientModel patientDetails) {
        Optional<PatientModel> patientOptional = patientRepository.findById(id);
        if (patientOptional.isPresent()) {
            PatientModel patient = patientOptional.get();
            patient.setName(patientDetails.getName());
            patient.setAge(patientDetails.getAge());
            patient.setGender(patientDetails.getGender());
            patient.setAddress(patientDetails.getAddress());
            PatientModel updatedPatient = patientRepository.save(patient);
            return ResponseEntity.ok(updatedPatient);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletePatient(@PathVariable Integer id) {
        Optional<PatientModel> patientOptional = patientRepository.findById(id);
        if (patientOptional.isPresent()) {
            patientRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
