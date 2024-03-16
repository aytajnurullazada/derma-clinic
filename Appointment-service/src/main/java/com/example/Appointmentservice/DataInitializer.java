package com.example.Appointmentservice;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.Appointmentservice.model.AppointmentModel;
import com.example.Appointmentservice.repository.AppointmentRepository;

@Configuration
public class DataInitializer {
        @Bean
    public CommandLineRunner loadAppointmentData(AppointmentRepository appointmentRepository) {
        return args -> {
            AppointmentModel appointment1 = new AppointmentModel("1");
            appointment1.setAppointmentId(1001);
            appointment1.setPatientId(1);
            appointment1.setDate(LocalDate.of(2024, 3, 16));
            appointment1.setMemberType("Premium");

            appointmentRepository.save(appointment1);

            AppointmentModel appointment2 = new AppointmentModel("2");
            appointment2.setAppointmentId(1002);
            appointment2.setPatientId(2);
            appointment2.setDate(LocalDate.of(2024, 3, 17));
            appointment2.setMemberType("Regular");

            appointmentRepository.save(appointment2);
        };
    }
}
