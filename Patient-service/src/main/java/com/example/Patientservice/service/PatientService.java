package com.example.Patientservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Patientservice.dto.PatientDto;
import com.example.Patientservice.model.PatientModel;
import com.example.Patientservice.repository.PatientRepository;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public List<PatientDto> getAllPatients() {
        Iterable<PatientModel> patients = patientRepository.findAll();
        List<PatientDto> patientDto = new ArrayList<>();
        for (PatientModel patientModel : patients) {
            patientDto.add(mapToPatientDto(patientModel));
        }
        return patientDto;
    }

    public Optional<PatientDto> getPatientById(String id) {
        Optional<PatientModel> optionalPatient = patientRepository.findById(id);
        return optionalPatient.map(this::mapToPatientDto);
    }

    public void addPatient(PatientDto patientDto) {
        PatientModel patientModel = mapToPatientModel(patientDto);
        patientRepository.save(patientModel);
    }

    public void updatePatient(String id, PatientDto updatedPatientDto) {
        Optional<PatientModel> optionalPatient = patientRepository.findById(id);
        if (optionalPatient.isPresent()) {
            PatientModel patient = optionalPatient.get();
            patient.setName(updatedPatientDto.getName());
            patient.setAge(updatedPatientDto.getAge());
            // Set other properties as needed
            patientRepository.save(patient);
        }
        // Handle the case when patient with given id is not found
    }

    // Helper methods for mapping between DTO and model
    private PatientDto mapToPatientDto(PatientModel patientModel) {
        return new PatientDto(patientModel.getId());
        // You may need to map other properties here
    }

    private PatientModel mapToPatientModel(PatientDto patientDto) {
        PatientModel patientModel = new PatientModel(patientDto.getId());
        patientModel.setName(patientDto.getName());
        patientModel.setAge(patientDto.getAge());
        // Set other properties as needed
        return patientModel;
    }
}
