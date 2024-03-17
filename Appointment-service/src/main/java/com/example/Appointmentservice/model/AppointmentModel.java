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
@AllArgsConstructor
@NoArgsConstructor

public class AppointmentModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int AppointmentId;
    private int PatientId;
    private LocalDate Date;
    private String memberType;
    


    public void setAppointmentId(int appointmentId) {
        AppointmentId = appointmentId;
    }



    public void setPatientId(int patientId) {
        PatientId = patientId;
    }



    public void setDate(LocalDate date) {
        Date = date;
    }



    public void setMemberType(String memberType) {
        this.memberType = memberType;
    }



    public Long getId() {
        return id;
    }



    public int getAppointmentId() {
        return AppointmentId;
    }



    public int getPatientId() {
        return PatientId;
    }



    public LocalDate getDate() {
        return Date;
    }



    public String getMemberType() {
        return memberType;
    }



    public AppointmentModel(Long id){
        this.id =id;
        }



    @Override
    public String toString() {
        return "AppointmentModel [id=" + id + ", AppointmentId=" + AppointmentId + ", PatientId=" + PatientId
                + ", Date=" + Date + ", memberType=" + memberType + "]";
    }
}

    

