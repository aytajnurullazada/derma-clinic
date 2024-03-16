package com.example.Appointmentservice.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name="AppointmentTable")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor

public class AppointmentModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private int AppointmentId;
    private int PatientId;
    private LocalDate Date;
    private String memberType;
    


    public AppointmentModel(String id){
        this.id =id;
        }
}

    

