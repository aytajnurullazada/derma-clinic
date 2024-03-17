package com.example.Appointmentservice.controller;

import com.example.Appointmentservice.dto.AppointmentDto;
import com.example.Appointmentservice.model.AppointmentModel;
import com.example.Appointmentservice.repository.AppointmentRepository;
import com.example.Appointmentservice.services.AppointmentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private AppointmentServices appointmentServices;
    


    @GetMapping("/{id}")
    public ResponseEntity<AppointmentModel> findById(@PathVariable Long id) {
        java.util.Optional<AppointmentModel> patientOptional = appointmentRepository.findById(id);
        if (patientOptional.isPresent()) {
            AppointmentModel patient = patientOptional.get();
            return ResponseEntity.ok(patient);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/all")
    public List<AppointmentModel> getAllAppointmentModels() {
        Iterable<AppointmentModel> appointmentIterable = appointmentRepository.findAll();
        List<AppointmentModel> appointmentList = StreamSupport.stream(appointmentIterable.spliterator(), false)
                                        .collect(Collectors.toList());
        return appointmentList;
    }
    @PostMapping("/add")
    public ResponseEntity<AppointmentModel> saveAppointment(@RequestBody AppointmentDto appointmentDto) {
        try {
            System.out.println("app_model : " + appointmentDto);

            // Save the appointment
            AppointmentModel savedAppointment = appointmentServices.createAppointment(appointmentDto);
            System.out.println("saved_model : " + savedAppointment);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedAppointment);
        } catch (Exception e) {
            // Handle any exceptions and return an appropriate response
            return ResponseEntity.internalServerError().build();
        }
    }
  
    @PutMapping("/update/{id}")
    public ResponseEntity<AppointmentModel> updateAppointment(@PathVariable Long id, @RequestBody AppointmentModel appointmentDetails) {
        Optional<AppointmentModel> appointmentOptional = appointmentRepository.findById(id);
        if (appointmentOptional.isPresent()) {
            AppointmentModel appointment = appointmentOptional.get();
            appointment.setAppointmentId(appointmentDetails.getAppointmentId());
            appointment.setPatientId(appointmentDetails.getPatientId());
            appointment.setDate(appointmentDetails.getDate());
            appointment.setMemberType(appointmentDetails.getMemberType());
            AppointmentModel updatedAppointment = appointmentRepository.save(appointment);
            return ResponseEntity.ok(updatedAppointment);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteAppointment(@PathVariable Long id) {
        appointmentServices.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    
}
