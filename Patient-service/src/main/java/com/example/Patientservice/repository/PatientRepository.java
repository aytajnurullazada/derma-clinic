package com.example.Patientservice.repository;

import org.springframework.data.repository.CrudRepository;
import com.example.Patientservice.model.PatientModel;
import java.util.Optional;

public interface PatientRepository extends CrudRepository<PatientModel, Integer> {
    Optional<PatientModel> findById(Integer id);
}
