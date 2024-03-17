package com.example.Appointmentservice.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.Appointmentservice.model.AppointmentModel;


public interface AppointmentRepository extends CrudRepository<AppointmentModel, Integer> {
    
}
