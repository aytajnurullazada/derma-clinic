package com.example.Appointmentservice.repository;

import org.springframework.data.repository.CrudRepository;
import com.example.Appointmentservice.model.AppointmentModel;
import java.util.Optional;
import java.lang.Long;

public interface AppointmentRepository extends CrudRepository<AppointmentModel , Long>{
    Optional<AppointmentModel> findById(Long id);
}
