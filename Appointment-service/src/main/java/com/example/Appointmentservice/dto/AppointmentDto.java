package com.example.Appointmentservice.dto;

import java.time.LocalDate;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor



public class AppointmentDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private int AppointmentId;
    private int PatientId;
    private LocalDate Date;
    private String memberType;
    


    public AppointmentDto(String id){
        this.id =id;
        }
}
