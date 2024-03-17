package com.example.Appointmentservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.sql.init.dependency.DatabaseInitializerDetector;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
// @EnableDiscoveryClient
public class AppointmentServiceApplication {
@Bean
	@LoadBalanced
		public WebClient.Builder getWebClientBuilder() {
			return  WebClient.builder();
		}
	public static void main(String[] args) {
		//DatabaseInitializer.initialize("appointmentserviceDB");
		SpringApplication.run(AppointmentServiceApplication.class, args);
	}

}
