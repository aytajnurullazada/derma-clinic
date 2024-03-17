package com.example.Appointmentservice.controller;

import java.time.LocalDate;
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
import com.example.Appointmentservice.services.AppointmentServices;

import io.swagger.v3.oas.annotations.parameters.RequestBody;


@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private AppointmentServices appointmentServices;
    


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
    // @PostMapping("/add")
    // public ResponseEntity<AppointmentModel> saveAppointment(@RequestBody AppointmentModel appointmentModel) {
    //     try {
    //         // Set the current date if not provided in the request
    //         if (appointmentModel.getDate() == null) {
    //             appointmentModel.setDate(LocalDate.now());
    //         }
            
    //         // Save the appointment
    //         AppointmentModel savedAppointment = appointmentRepository.save(appointmentModel);
    //         return ResponseEntity.status(HttpStatus.SC_CREATED).body(savedAppointment);
    //     } catch (Exception e) {
    //         // Handle any exceptions and return an appropriate response
    //         return ResponseEntity.status(HttpStatus.SC_INTERNAL_SERVER_ERROR).build();
    //     }
    // }
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

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAppointment(@PathVariable String id) {
        appointmentServices.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    
}
