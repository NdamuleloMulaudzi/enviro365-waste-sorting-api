
# Enviro365 Waste Sorting Mobile Application

This project is a backend implementation for the **Enviro365 Waste Sorting Mobile Application**, aimed at promoting sustainable waste management practices. 
The application provides functionalities for managing waste categories, disposal guidelines, and recycling tips.

## Features

- **Waste Categories**: Manage waste categories like "Plastic", "Paper", etc.
- **Disposal Guidelines**: Retrieve guidelines for proper waste disposal.
- **Recycling Tips**: Display tips for effective recycling.
- **RESTful APIs**: Expose endpoints for CRUD operations on the above entities.
- **Validation**: Validate input data before processing.

## Technologies Used

- **Spring Boot**: Backend framework for building the RESTful APIs.
- **H2 Database**: In-memory database for storing and retrieving data.
- **Spring Data JPA**: For database interaction.
- **Jakarta Validation**: For input validation.

## Project Structure

```
src/main/java/com/enviro/assessment/grad001/ndamulelomulaudzi/
    ├──  Enviro365WasteSortingApiApplication              # Main Spring Boot application class
    ├── controller/                    # Contains REST controllers
    │   ├── WasteCategoryController.java
    │   ├── DisposalGuidelineController.java
    │   └── RecyclingTipController.java
    ├── model/                       #Entity classes 
    │   ├── WasteCategory.java
    │   ├── DisposalGuideline.java
    │   └── RecyclingTip.java
    ├── repository/                    # Repository interfaces for data persistence
    │   ├── WasteCategoryRepository.java
    │   ├── DisposalGuidelineRepository.java
    │   └── RecyclingTipRepository.java
    ├── service/                         #logic layer
    │   ├── WasteCategoryService.java
    │   ├── DisposalGuidelineService.java
    │   └── RecyclingTipService.java
```

## Setup Instructions

1. **Clone the Repository**
   ```bash/terminal
   git clone https://github.com/NdamuleloMulaudzi/enviro365-waste-sorting-api.git
   cd enviro365-waste-sorting-api
   ```

2. **Build and Run the Application**
   - Make sure you have **Java 17+** and **Maven** installed.
   - Run the application using Maven:
     ```bash
     ./mvnw spring-boot:run
     ```

3. **Accessing the Application**
   The application will be running on `http://localhost:8080`. You can test the REST endpoints using tools like **Postman** or **curl**.

## API Endpoints

### Waste Categories

- **GET /api/waste-categories**: Retrieve all waste categories.
- **GET /api/waste-categories/{id}**: Retrieve a specific waste category by ID.
- **POST /api/waste-categories**: Create a new waste category.
- **PUT /api/waste-categories/{id}**: Update an existing waste category.
- **DELETE /api/waste-categories/{id}**: Delete a waste category.

### Disposal Guidelines

- **GET /api/disposal-guidelines**: Retrieve all disposal guidelines.
- **GET /api/disposal-guidelines/{id}**: Retrieve a specific disposal guideline by ID.
- **POST /api/disposal-guidelines**: Create a new disposal guideline.
- **PUT /api/disposal-guidelines/{id}**: Update an existing disposal guideline.
- **DELETE /api/disposal-guidelines/{id}**: Delete a disposal guideline.

### Recycling Tips

- **GET /api/recycling-tips**: Retrieve all recycling tips.
- **GET /api/recycling-tips/{id}**: Retrieve a specific recycling tip by ID.
- **POST /api/recycling-tips**: Create a new recycling tip.
- **PUT /api/recycling-tips/{id}**: Update an existing recycling tip.
- **DELETE /api/recycling-tips/{id}**: Delete a recycling tip.

## Example Request

- **Create a Waste Category**:
  - **URL**: `POST /api/waste-categories`
  - **Body**:
    ```json
    {
        "name": "Plastic",
        "description": "Non-biodegradable waste"
    }
    ```

- **Update a Waste Category**:
  - **URL**: `PUT /api/waste-categories/1`
  - **Body**:
    ```json
    {
        "name": "Plastic Waste",
        "description": "Plastic waste that can be recycled"
    }
    ```

## Validation

- Required fields are validated using annotations like `@NotBlank`.
