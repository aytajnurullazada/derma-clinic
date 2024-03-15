package com.example.Patientservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.Patientservice.service.PatientService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class PatientController {
@Autowired
private PatientService patientService;

@GetMapping("path")
public String getMethodName(@RequestParam String param) {
    return new String();
}

    
}
