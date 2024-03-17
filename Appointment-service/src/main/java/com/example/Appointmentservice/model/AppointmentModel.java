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
@Table(name = "AppointmentTable")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; // Changed from String to int
    private int appointmentId;
    private int patientId;
    private LocalDate date;
    private String memberType;

}
