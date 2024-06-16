# ProjDB

## Overview
Addressing the common issue of projects being halted and abandoned post-graduation, along with the challenge faced by teachers in effectively monitoring student projects, our application seeks to revolutionize project management in academic settings.

## Key Features

### Seamless Authentication
Users can effortlessly log in using their university authentication credentials, ensuring a secure and streamlined onboarding process.

### Effortless Class and Group Formation
Teachers gain the ability to create classes and form groups within the application, facilitating efficient project organization.

### Comprehensive Project Details
Students can log in and input project details, fostering transparency and accountability in the project management process.

### Integrated Bug Management
The application incorporates a robust bug management system, accessible to staff for class projects, ensuring prompt issue resolution.

### Version Control Integration
To enhance collaboration, students are prompted to provide version control authentication through webhooks, enabling real-time tracking of project changes.

### Project Continuity
In instances where a student is unable to continue their project, teachers can seamlessly reassign it within the application, ensuring project continuity and completion.

### Independent Project Collaboration
Students have the option to initiate independent projects and can mark them as "Calling for Teammates" or "Calling for Help," promoting collaboration and community support.

By addressing these challenges and providing a comprehensive platform for project management, our application aims to foster a more conducive environment for project completion and success in academic settings.

## Running the Project

### Prerequisites
- Java Development Kit (JDK) 11 or higher
- Maven 3.6.0 or higher
- MySQL or any preferred database setup

### Configure Database

1. **Create Database**
   - Create a MySQL database named `projdb`.

2. **Update Configuration**
   - Open `src/main/resources/application.properties`.
   - Update the database configurations:
     ```properties
     spring.datasource.url=jdbc:mysql://localhost:3306/projdb
     spring.datasource.username=your_db_username
     spring.datasource.password=your_db_password
     ```

### Build the Project

1. **Clone the Repository**
   ```bash
   git clone https://github.com/yourusername/projdb.git
   cd projdb

2. **Build with Maven**
   ```bash
   mvn clean install

3. **Start the Application**
   ```bash
   mvn spring-boot:run

### Access the Application
Open your web browser and go to: http://localhost:8080

### Additional Notes
  - Ensure your MySQL server is running.
  - You can customize other application settings in application.properties as needed.
  - For development purposes, you may use H2 in-memory database by adjusting the configurations in `application.properties`.
