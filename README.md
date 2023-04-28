# Foodverse 

## Author : Jay Ramani

## Getting Started

### **Descripton:**

This is an online food ordering application built using Java, Spring Boot, and MySQL. The application allows users to browse through a variety of food items, place orders, and make payments online. It includes features like user authentication, cart management, order history, and online payments.

### **Prerequisites:**

Before using this project, you'll need to have the following installed:

- JDK Version 8
- MySQL version 8
- Spring boot version 2.6.5 

### **How to Use:**

To install this project, follow these steps:

1. Clone the repository: git clone https://github.com/jayramani/Foodverse.git
2. Navigate to the Project directory: cd Foodverse
3. Update the database connection details in the application.properties file located in the src/main/resources directory.
```
   - spring.datasource.url=<MYSQL_SERVER_CONNECTION_STRING>
   - spring.datasource.usernameT=<MYSQL_SERVER_USERNAME>
   - spring.datasource.password=<MYSQL_SERVER_PASSWORD>
```   
4. Build the project using Maven by running the following command: 
```
mvn clean install
```
5. Run the Spring Boot application using the following command: 
```
mvn spring-boot:run
```
6. Open a web browser and go to http://localhost:8081 to access the application





