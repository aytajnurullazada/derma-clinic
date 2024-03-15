package com.example.Patientservice.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.Patientservice.model.PatientModel;

public interface PatientRepository extends CrudRepository<PatientModel , String>{


} 
