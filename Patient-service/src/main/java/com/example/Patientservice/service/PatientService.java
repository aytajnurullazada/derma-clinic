package com.example.Patientservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Patientservice.model.PatientModel;
import com.example.Patientservice.repository.PatientRepository;
import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public Optional<PatientModel> findById(Integer id) {
        return patientRepository.findById(id);
    }

    public List<PatientModel> getAllPatients() {
        return (List<PatientModel>) patientRepository.findAll();
    }

    public PatientModel createPatient(PatientModel patient) {
        return patientRepository.save(patient);
    }

    public Optional<PatientModel> updatePatient(Integer id, PatientModel patientDetails) {
        Optional<PatientModel> patientOptional = patientRepository.findById(id);
        if (patientOptional.isPresent()) {
            PatientModel patient = patientOptional.get();
            patient.setName(patientDetails.getName());
            patient.setAge(patientDetails.getAge());
            patient.setGender(patientDetails.getGender());
            patient.setAddress(patientDetails.getAddress());
            return Optional.of(patientRepository.save(patient));
        } else {
            return Optional.empty();
        }
    }

    public boolean deletePatient(Integer id) {
        if (patientRepository.existsById(id)) {
            patientRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
