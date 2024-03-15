package com.example.Patientservice.dto;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor

public class PatientDto {
    @Id
    private String id;
    private String name;
    private int age;
    private String gender;
    private String address;

public PatientDto(String id){
    this.id = id;
    }

}
