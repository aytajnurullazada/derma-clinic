package com.example.Patientservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Patientservice.dto.PatientDto;
import com.example.Patientservice.repository.PatientRepository;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public List<PatientDto> getAllPatients() {
        return patientRepository.findAll();
    }

    public Optional<PatientDto> getPatientById(String id) {
        return patientRepository.findById(id);
    }

    public void addPatient(PatientDto patient) {
        patientRepository.save(patient);
    }

    public void updatePatient(String id, PatientDto updatedPatient) {
        Optional<PatientDto> optionalPatient = patientRepository.findById(id);
        if (optionalPatient.isPresent()) {
            PatientDto patient = optionalPatient.get();
            patient.setName(updatedPatient.getName());
            patient.setAge(updatedPatient.getAge());
            patient.setGender(updatedPatient.getGender());
            patient.setAddress(updatedPatient.getAddress());
            patient.setMobile(updatedPatient.getMobile());
            patientRepository.save(patient);
        }
        // Handle the case when patient with given id is not found
    }

    public void deletePatientById(String id) {
        patientRepository.deleteById(id);
    }
}
