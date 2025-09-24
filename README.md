# CMS Spring Boot Project

This is a Spring Boot web application project implementing a basic Content Management System (CMS).

## Project Structure

```
src/
  main/
    java/
      com/app/          # Java classes (entities, controllers, services, etc.)
    resources/
      application.properties  # configuration file
    webapp/
      WEB-INF/
        views/          # JSP or other view templates
pom.xml                  # Maven build file
```

## Technologies Used

* Java
* Spring Boot (Spring MVC, Spring Web)
* Spring Data JPA
* Maven
* JSP / Thymeleaf (for views)
* Relational Database (configured in `application.properties`)

## Features & Relationships

* Entities are defined in `src/main/java/com/app`.
* Typical relationships between entities:
* 
  * Entities are linked via primary and foreign keys using JPA annotations.
* Server-side rendered views are under `WEB-INF/views`.
* Functionality is implemented according to the classes in the code.

## Notes

* All configurations are in `src/main/resources/application.properties`.
* The project structure follows standard Spring Boot conventions.
* All features are driven by the Java classes present in the code.


The application will be available at `http://localhost:8080/`.
