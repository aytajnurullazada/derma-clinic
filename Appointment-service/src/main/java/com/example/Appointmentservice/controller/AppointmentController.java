package com.example.Appointmentservice.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Appointmentservice.model.AppointmentModel;
import com.example.Appointmentservice.repository.AppointmentRepository;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @GetMapping("/{id}")
    public ResponseEntity<AppointmentModel> findById(@PathVariable int id) { // Changed from String to int
        Optional<AppointmentModel> appointmentOptional = appointmentRepository.findById(id);
        return appointmentOptional
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/all")
    public List<AppointmentModel> getAllAppointments() {
        Iterable<AppointmentModel> appointmentIterable = appointmentRepository.findAll();
        return StreamSupport.stream(appointmentIterable.spliterator(), false)
                                        .collect(Collectors.toList());
    }

    @PostMapping("/add")
    public ResponseEntity<AppointmentModel> createAppointment(@RequestBody AppointmentModel appointment) {
        AppointmentModel savedAppointment = appointmentRepository.save(appointment);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedAppointment);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<AppointmentModel> updateAppointment(@PathVariable int id, @RequestBody AppointmentModel appointmentDetails) { // Changed from String to int
        return appointmentRepository.findById(id)
                .map(existingAppointment -> {
                    existingAppointment.setAppointmentId(appointmentDetails.getAppointmentId()); 
                    existingAppointment.setPatientId(appointmentDetails.getPatientId());
                    existingAppointment.setDate(appointmentDetails.getDate());
                    existingAppointment.setMemberType(appointmentDetails.getMemberType());
                    AppointmentModel updatedAppointment = appointmentRepository.save(existingAppointment);
                    return ResponseEntity.ok(updatedAppointment);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteAppointment(@PathVariable int id) { // Changed from String to int
        if (appointmentRepository.existsById(id)) {
            appointmentRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
