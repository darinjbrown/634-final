# React and Spring Boot Project

This project consists of two main modules:
- **Frontend**: A React application running on port 3000
- **Backend**: A Spring Boot application running on port 8080

## Project Structure
634-final/backend #Spring Boot Application
634-final/frontend #React Application

## Prerequisites
Ensure the following are installed on your system:
- **Java 17 or higher**
- **Maven** (if not using Maven Wrapper)
- **Node.js** (with npm)

## Installation

### 1. Clone the Repository
git clone <repository-url>
cd project-root

### 2. Backend Setup
Navigate to the backend directory: cd backend
#### If using Maven Wrapper:
./mvnw clean install

./mvnw spring-boot:run
#### If Maven installed globally:
mvn clean install
mvn spring-boot:run


### 3. Frontend Setup
Navigate to the frontend directory: cd frontend
#### npm start

### Communication Between Frontend and Backend
The React frontend communicates with the Spring Boot backend via HTTP requests. Ensure the backend is running before starting the frontend.

### Additional Notes
- **The backend uses an in-memory H2 database for development purposes.**
- **CORS is configured to allow requests from http://localhost:3000.**

### Troubleshooting
- **If mvnw is not recognized, ensure you are in the correct directory and the Maven Wrapper files exist.**
- **If the frontend fails to start, ensure all dependencies are installed using npm install.**