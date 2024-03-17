Derma-Clinic
Welcome to Derma-Clinic! This project focuses on providing dermatology clinic services. It consists of several microservices built using Java Spring Boot. Initially, we utilize Eureka Discovery Registry services to register microservices and make them discoverable.

Overview
The project architecture is outlined in the following Miro board: Derma-Clinic Architecture

Appointment Microservice
The Appointment Microservice manages the registration of appointments. It captures basic information about the patient, appointment date & time, the requester, and subscription type. CRUD operations are implemented for managing appointment data.

Patient Microservice
The Patient Microservice deals with patient-specific information, focusing on basic personal details. It handles CRUD operations for managing patient data.

Setup
To run the project locally, follow these steps:

Clone the repository:

bash
Copy code
https://github.com/aytajnurullazada/derma-clinic.git
Navigate to the project directory:

bash
Copy code
cd derma-clinic
Start the Eureka Discovery Registry Service:

bash
Copy code

# Command to start Eureka service

http://localhost:8761
Start the individual microservices:

bash
Copy code

# Command to start Appointment Microservice

http://localhost:8081/swagger-ui/4.15.5/index.html

# Command to start Patient Microservice

http://localhost:8082/swagger-ui/4.15.5/index.html
Access the services through their respective endpoints.
