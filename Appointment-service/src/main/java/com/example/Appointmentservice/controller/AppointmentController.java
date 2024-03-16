package com.example.Appointmentservice.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.apache.hc.core5.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Appointmentservice.model.AppointmentModel;
import com.example.Appointmentservice.repository.AppointmentRepository;

import io.swagger.v3.oas.annotations.parameters.RequestBody;


@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    @Autowired
    private AppointmentRepository appointmentRepository;

        @GetMapping("/{id}")
    public ResponseEntity<AppointmentModel> findById(@PathVariable String id) {
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
    public ResponseEntity<AppointmentModel> createAppointment(@RequestBody AppointmentModel appointment) {
        AppointmentModel appointmentModel = appointmentRepository.save(appointment);
        return ResponseEntity.status(HttpStatus.SC_CREATED).body(appointmentModel);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<AppointmentModel> updateAppointment(@PathVariable String id, @RequestBody AppointmentModel appointmentDetails) {
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

    //  @DeleteMapping("/delete/{id}")
    // public ResponseEntity<Void> deleteAppointment(@PathVariable String id) {
    //     Optional<AppointmentModel> appointmentIterable = appointmentIterable.findById(id);
    //     if (appointmentIterable.isPresent()) {
    //         appointmentIterable.deleteById(id);
    //         return ResponseEntity.noContent().build();
    //     } else {
    //         return ResponseEntity.notFound().build();
    //     }
    // }
    
}
