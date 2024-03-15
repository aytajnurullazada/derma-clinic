package com.example.Patientservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.Patientservice.model.PatientModel;
import com.example.Patientservice.repository.PatientRepository;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner loadPatientsData(PatientRepository patientRepository) {
        return args -> {
            PatientModel patient1 = new PatientModel("1");
            patient1.setName("John Doe");
            patient1.setAge(30);
            patient1.setGender("Male");
            patient1.setAddress("123 Main St");
            patient1.setMobile("123-456-7890");

            patientRepository.save(patient1);

            PatientModel patient2 = new PatientModel("2");
            patient2.setName("Jane Smith");
            patient2.setAge(25);
            patient2.setGender("Female");
            patient2.setAddress("456 Elm St");
            patient2.setMobile("987-654-3210");

            patientRepository.save(patient2);
        };
    }
    
}
