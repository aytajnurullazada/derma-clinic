package com.example.Appointmentservice.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentDto {
    private int id; // Type changed from String to int, JPA annotations removed
    private int appointmentId;
    private int patientId;
    private LocalDate date;
    private String memberType;

    // If you still need a constructor for setting id, adjust its type
    public AppointmentDto(int id){
        this.id = id;
    }
}
