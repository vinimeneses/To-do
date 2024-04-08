# To-do

This project is a simple To-do list application built using the Spring framework. It allows users to create, update, delete, and view tasks conveniently. The application follows the principles of RESTful API design, making it easy to integrate with other systems.

## Features

- **CRUD Operations**: Users can create, read, update, and delete tasks.
- **RESTful API**: The application follows RESTful principles for easy integration and scalability.
- **Persistence**: Tasks are stored in a database, ensuring data persistence across sessions.
- **Authentication**: Provides authentication mechanisms to ensure secure access to the application.
- **Authorization**: Implements authorization to control access to specific resources based on user roles.

## Technologies Used

- **Spring Boot**: Provides a robust framework for building and deploying Java applications.
- **Spring MVC**: Enables the development of web applications following the Model-View-Controller pattern.
- **Spring Data JPA**: Simplifies data access by providing a high-level abstraction over JPA.
- **Hibernate**: Acts as the ORM (Object-Relational Mapping) tool for mapping Java entities to database tables.
- **Spring Security**: Offers authentication and authorization features to secure the application.
- **MySQL**: Utilized as the relational database management system for storing task data.

## Getting Started

### Prerequisites

- Java Development Kit (JDK) installed on your machine.
- Maven installed to manage project dependencies.
- MySQL database server installed locally or accessible remotely.
- IDE (Integrated Development Environment) such as IntelliJ IDEA or Eclipse.

### Installation

1. Clone the repository:

```bash
git clone https://github.com/vinimeneses/To-do.git
```

2. Open the project in your preferred IDE.

3. Configure the database connection in `src/main/resources/application.properties`.

4. Build the project using Maven:

```bash
mvn clean install
```

5. Run the application:

```bash
mvn spring-boot:run
```


## Usage

1. Navigate to the application's URL in your web browser.
2. Sign up for a new account or log in if you already have one.
3. Once authenticated, you can perform CRUD operations on tasks.

## Swagger API Documentation

Our application uses Swagger for API documentation. Swagger provides a set of great tools for designing, building, and documenting RESTful APIs. It also provides a user-friendly interface to explore and test the API.

### Accessing Swagger UI

Once the application is running, you can access the Swagger UI at:
`http://localhost:8080/swagger-ui/`

## API Endpoints

This Todo Management application provides the following RESTful API endpoints:

- `GET /api/todos`: Fetch all todos
- `GET /api/todos/{id}`: Fetch a todo by ID
- `POST /api/todos`: Create a new todo
- `PUT /api/todos/{id}`: Update a todo
- `DELETE /api/todos/{id}`: Delete a todo


## Contribution

Contributions to the project are welcome. If you find any issues or have suggestions for improvements, feel free to open an issue or create a pull request.
