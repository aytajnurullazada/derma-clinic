package com.example.Patientservice;

import javax.sql.DataSource;

import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;


@Configuration
public class DatabaseInitializer {
        public static void initialize(String nameOfDatabase) {
        String url = "jdbc:postgresql://localhost:5432/";
        String username = "postgres";
        String password = "1234";
        String databaseName = nameOfDatabase;

        DataSource dataSource = new DriverManagerDataSource(url, username, password);
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        // this will create the database if it doesn't exist in mysql but not in
        try {
            jdbcTemplate.execute("CREATE DATABASE " + databaseName);
        } catch (Exception e) {
            System.err.println("Database already exists");
        }

    }
}
