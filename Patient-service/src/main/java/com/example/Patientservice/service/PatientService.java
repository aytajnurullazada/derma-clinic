package com.example.Patientservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Patientservice.repository.PatientRepository;

@Service
public class PatientService {

@Autowired
private PatientRepository patientRespository;

}
