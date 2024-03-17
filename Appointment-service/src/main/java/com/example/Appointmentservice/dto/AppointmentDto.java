package com.example.Appointmentservice.dto;

import java.time.LocalDate;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor



public class AppointmentDto {

    private String id;
    private String AppointmentId;
    private String PatientId;
    private LocalDate Date;
    private String memberType;
    


    public AppointmentDto(String id){
        this.id =id;
        }
}
