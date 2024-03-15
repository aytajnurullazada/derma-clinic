package com.example.Patientservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="patientInfo")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor

public class PatientModel {
    @Id
    private String id;
    private String name;
    private int age;
    private String gender;
    private String address;
    private String mobile;
    
public PatientModel(String id){
    this.id =id;
    }
}
