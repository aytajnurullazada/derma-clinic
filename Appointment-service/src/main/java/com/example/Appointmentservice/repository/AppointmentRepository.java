package com.example.Appointmentservice.repository;

import org.springframework.data.repository.CrudRepository;
import com.example.Appointmentservice.model.AppointmentModel;
import java.util.Optional;
import java.lang.String;

public interface AppointmentRepository extends CrudRepository<AppointmentModel , String>{
    Optional<AppointmentModel> findById(String id);
}
