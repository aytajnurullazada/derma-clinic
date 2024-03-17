package com.example.Appointmentservice.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.Appointmentservice.model.AppointmentModel;
import com.example.Appointmentservice.repository.AppointmentRepository;

@Service
public class AppointmentServices {

    @Autowired
    private AppointmentRepository appointmentRepository;

    public ResponseEntity<AppointmentModel> findById(Long id) {
        Optional<AppointmentModel> appointmentOptional = appointmentRepository.findById(id);
        return appointmentOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    public List<AppointmentModel> getAllAppointments() {
        return (List<AppointmentModel>) appointmentRepository.findAll();
    }

    public ResponseEntity<AppointmentModel> createAppointment(AppointmentModel appointment) {
       
        AppointmentModel appointmentModel = appointmentRepository.save(appointment);
        return ResponseEntity.ok(appointmentModel);
    }

    public ResponseEntity<AppointmentModel> updateAppointment(Long id, AppointmentModel appointmentDetails) {
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

    public void deleteAppointmentById(Long id) {
        appointmentRepository.deleteById(id);
    }

    public void deleteById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }
}
