# Access Control for Schools (In Progress)

## Description

This project is an **access control system built specifically for schools**, designed to manage user roles, permissions, and access to various resources. It leverages modern technologies like **Spring Boot** and **Spring Security** to handle authentication and authorization effectively.

This system is a modernization of an older project that was originally built using a **client-server architecture** years ago. The current version is being redesigned to take advantage of modern web frameworks, providing enhanced security, flexibility, and scalability for today's educational institutions.

## Technologies Used

- **Java 17**
- **Spring Boot 3.3.0**
- **Spring Security**
- **H2 Database** (for development)
- **Thymeleaf** (for templating)
- **Bootstrap** (for responsive UI)

## Installation

1. Clone the repository:  
   `git clone https://github.com/your-username/access-control.git`
2. Navigate to the project directory:  
   `cd access-control`
3. Build the project:  
   `./gradlew build`
4. Run the application:  
   `./gradlew bootRun`

## Usage

1. Open your web browser and navigate to:  
   `http://localhost:8080`
2. Log in using the credentials:  
   `admin` / `password`
3. Manage user roles, permissions, and school-specific access policies via the provided user interface.

> **Note:** This project is a **work in progress**. Some features are currently under development as we continue to build out the functionality needed to modernize the original client-server system. Expect future updates that include more advanced role management and security features tailored to schools.

## Purpose of the Modernization

The original project was designed using a traditional **client-server architecture**, which over time became outdated and less scalable. This new implementation not only recreates the original features but also introduces improvements using modern web technologies, making the system more adaptable to current educational needs, including:

- Web-based access from any device.
- Enhanced role-based access control for staff, teachers, students, and administrators.
- Scalable architecture that can grow with the school’s needs.

## Contributing

Contributions are welcome! If you encounter any issues or have suggestions for further improvements, please feel free to open an issue or submit a pull request.

### How to contribute:

1. Fork the repository.
2. Create your feature branch:  
   `git checkout -b feature/your-feature`
3. Commit your changes:  
   `git commit -m 'Add some feature'`
4. Push to the branch:  
   `git push origin feature/your-feature`
5. Open a pull request.

## License

This project is licensed under the Apache License 2.0. See the [LICENSE](LICENSE) file for more details.
