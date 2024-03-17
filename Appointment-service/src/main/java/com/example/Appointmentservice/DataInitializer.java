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
            AppointmentModel appointment1 = AppointmentModel.builder()
                    .appointmentId(1001)
                    .patientId(1)
                    .date(LocalDate.of(2024, 3, 16))
                    .memberType("Premium")
                    .build();

            appointmentRepository.save(appointment1);

            AppointmentModel appointment2 = AppointmentModel.builder()
                    .appointmentId(1002)
                    .patientId(2)
                    .date(LocalDate.of(2024, 3, 17))
                    .memberType("Regular")
                    .build();

            appointmentRepository.save(appointment2);
        };
    }
}
