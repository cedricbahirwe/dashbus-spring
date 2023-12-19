# Bus Ticketing System: (DashBus)

## Please find the Frontend Project at [this Link](https://github.com/cedricbahirwe/dashbus)

## The documentation below can also be found in the [doc](/doc) directory
### ID: 23455

A Bus ticket booking application made using Spring Boot (Backend API side) and [React JS](https://github.com/cedricbahirwe/dashbus) (Frontend Web Side)


## 1. Project Requirements

### Project Purpose:
The main goal of the Spring Boot backend project is to develop a Bus Ticketing System that enables users to book bus tickets online for long-distance trips conveniently. The system aims to address the challenges faced by crowded bus parks, providing a digital solution to streamline the ticket booking process. Additionally, the project contributes to the broader objective of digitization in the transportation sector.



### Expected Outcomes:

1. **User-Friendly Booking System**: A user-friendly interface that allows passengers to search for buses easily, and securely book tickets online.

2. **Reduced Crowds at Bus Parks**: Minimize the congestion and waiting times at bus parks by providing a digital platform for ticket booking, reducing the need for on-site ticket purchases.

3. **Digital Payment Integration**: Enable secure online payment options, such as  mobile money, credit/debit cards or digital wallets, to streamline the payment process for users.

4. **Automated Ticketing Process**: Implement an automated ticket generation system that issues digital tickets upon successful booking, reducing manual processes and the likelihood of errors.

5. **Real-time Availability Updates**: Provide real-time updates on bus availability, and schedules, ensuring transparency and informed decision-making.

6. **User Accounts and Profiles**: Allow users to create accounts, and manage their booking history for a more personalized and efficient experience.


### Functionality:

1. **User Authentication and Authorization:**
    - A secure user authentication system to allow users to create accounts and log in.
    - User roles (e.g., passengers, administrators) with appropriate access permissions.

2. **Bus Information Management:**
    - Maintain a database of available buses, including details such as routes and schedule availability.
    - Support operations for adding, updating, and removing bus information.

3. **Booking Management:**
    - Handle the booking process, including reservation, and ticket generation.
    - Ensure that booking transactions are secure and provide confirmation to users.

4. **Payment Integration:**
    - Integrate with payment gateways to enable secure online transactions.

5. **User Profile and History:**
    - Allow users to create and manage profiles with personal information.
    - Maintain a booking history for users to view their past and upcoming trips.

6. **Search and Filters:**
    - Implement a search functionality for users to find buses based on routes.

7. **Security Measures:**
    - Implement security measures to protect user data, transactions, and the overall integrity of the system.
    - Use encryption for sensitive information, and follow best practices for securing the backend.
   
## 2. Project Plan

This part can also be found in [PDF](/doc/projectplan.pdf) format.

### Scope of the Project
The Bus Ticketing System project encompasses the following key features and functionalities:

- User Registration and Authentication
- Bus and Route Management
- Ticket Booking and Reservation
- User Profiles

### Timeline (1-Week Prototype):

1. **Project Setup and Backend Development (Days 1-2):**
   - Define project scope and requirements.
   - Implement backend functionalities for user registration, authentication, and basic bus management.

2. **Frontend Development and Integration (Days 3-4):**
   - Design and implement basic user interfaces for passenger interactions.
   - Integrate frontend and backend components for seamless interactions.

3. **Documentation and Finalization (Days 5-6):**
   - Document the codebase and key functionalities.
   - Prepare for a prototype release.

4. **Deploy and Release (Day 7):**
   - Deploy the prototype for testing and feedback.
   - Set up development environment and version control.

### Resources

1. **Development Team:**
   - One Developer (Myself)
2. **Testing:**
   - Manual Testing during development.
3. **Documentation:**
   - I concurrently code and document key functionalities.
4. **External Dependencies:**
   - Minimize external dependencies to expedite development.
   - If necessary, choose lightweight and easily integratable third-party tools or services.

### Deployment and Release

1. **Deployment:**
   - Deploy the prototype on a local environment or a lightweight cloud service (e.g., Render).
2. **Testing and Feedback:**
   - Conduct additional testing in the deployment environment.
   
### Documentation
1. **Technical Documentation:**
   - High-level architecture overview.
   - Key components and their interactions.
2. **User Guide:**
   - Quick instructions for user registration.
   - Steps for booking a bus ticket.
3. **Deployment Guide:**
   - Basic setup instructions for the development environment.

## 3. Source Code

Source Code: https://github.com/cedricbahirwe/dashbus-spring

Clone the project:
   - **SSH**: `git clone git@github.com:cedricbahirwe/dashbus-spring.git`
   - **HTTPS**: `git clone https://github.com/cedricbahirwe/dashbus-spring.git`

To run the project, I recommend using an appropriate IDE such as [IntelliJ IDEA](https://www.jetbrains.com/idea).

## 4. Database Schema
<img width="1080" alt="shots" src="https://github.com/cedricbahirwe/dashbus-spring/assets/49038614/2019297b-2bc4-4105-9db5-4918c0243df3">

## 5. User Documentation:

This application uses mainly Spring Boot and different associated dependencies.

So first thing we need to do is to install all dependencies present in our `pom.xml` file.
#### DB Credentials `(If needed)`:
- `username`: root
- `password`: root

The React client is found at https://github.com/cedricbahirwe/dashbus

## 6. Technical Documentation

This documentation can also be found in [PDF](/doc/techdoc.pdf) format.
#### Application Overview:

The **DashBus** project is a Spring Boot-based Bus Ticketing System designed to streamline the booking process for long-distance trips. 

Below is an overview of the application's architecture, implementation details, and key components.

#### Project Structure:

The application follows a modular structure organized under one package with the following components:

- **controller:** Contains controllers responsible for handling HTTP requests and managing the flow of data between the client and the backend.

- **domain:** Includes domain objects representing entities within the application, such as Ticket, User, TicketOrder, etc.

- **repository:** Houses repositories responsible for data access and interaction with the underlying database.

- **service:** Implements business logic and services necessary for the application's functionality.

#### Libraries and Frameworks:

The project utilizes the following libraries and frameworks:

1. **Spring Boot:**
   - **Description:** The core framework providing a simplified, convention-over-configuration, opinionated approach to building Spring-based applications.
   - **Usage:** Used as the foundation for developing the backend components of the Bus Ticketing System.

2. **Spring Boot Starter Web:**
   - **Description:** A starter for building web applications with Spring MVC.
   - **Usage:** Enables the development of RESTful APIs and handles HTTP requests.

3. **Spring Boot DevTools:**
   - **Description:** Provides development-time tools to enhance the development experience.
   - **Usage:** Enables automatic application restarts and other development-oriented features.

4. **H2 Database:**
   - **Description:** An in-memory database for development and testing purposes.
   - **Usage:** Used as a runtime dependency to facilitate local data storage during development.

5. **MySQL Connector/J:**
   - **Description:** The official MySQL JDBC driver for connecting the application to a MySQL database.
   - **Usage:** Enables the application to interact with a MySQL database in production environments.

6. **Lombok:**
   - **Description:** A library to simplify Java code by reducing boilerplate code through annotations.
   - **Usage:** Streamlines the creation of entity classes and getter/setter methods.

7. **Spring Boot Starter Test:**
   - **Description:** A starter for testing Spring Boot applications.
   - **Usage:** Provides testing support for the application, ensuring code reliability.

8. **Spring Boot Starter Data JPA:**
   - **Description:** A starter for using Spring Data JPA with Hibernate.
   - **Usage:** Simplifies data access through the Java Persistence API (JPA) and Hibernate.

9. **Tomcat JDBC:**
   - **Description:** A connection pool provided by Tomcat.
   - **Usage:** Helps manage database connections efficiently.

10. **Spring Security Starter:**
    - **Description**: Integrates Spring Security into the Bus Ticketing System, providing default configurations for authentication, authorization, and security best practices.

#### Application Flow:

1. **Controller Layer:**
   - Handles incoming HTTP requests.
   - Orchestrates the flow of data between the client and the backend.

2. **Service Layer:**
   - Implements business logic and services.
   - Interacts with the repository layer for data access.

3. **Repository Layer:**
   - Manages data access and communication with the underlying database.

4. **Domain Layer:**
   - Defines entities representing the core data structure of the application.

#### Build and Execution:

The project uses Maven as the build tool. The Spring Boot Maven Plugin is configured to package the application as a standalone JAR file. The application can be executed using the `java -jar` command.

You can also use an appropriate IDE to run the project, I recommend using [IntelliJ IDEA](https://www.jetbrains.com/idea).

### Conclusion:

This Bus Ticketing System leverages the Spring Boot framework and associated technologies to provide a scalable, 
efficient, and modular solution for online bus ticket bookings. 

The use of industry-standard libraries and frameworks contributes to the application's maintainability and robustness.
