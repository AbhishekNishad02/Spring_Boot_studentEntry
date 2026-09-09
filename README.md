# Student Management System (Spring Boot + MongoDB)

## Project Overview

This project is a basic backend application developed using Spring Boot and MongoDB. It is designed to manage student records by storing details such as name, roll number, marks, and entry date. The project follows a clean layered architecture using Entity, Repository, Service, and Controller.

The main goal of this project is to practice backend development concepts, REST API creation, and database integration with MongoDB.

---

## Features

* Add a new student record
* View all student records
* Find a student using roll number
* Delete a student record
* Automatically store date and time of entry
* Ensure unique roll number using database indexing

---

## Tech Stack

* Java
* Spring Boot
* Spring Data MongoDB
* MongoDB
* Maven

---

## Project Structure

src/main/java/com.students.std/

* Entity
* StudentEntry.java
* Repository
* Services
* Controller

---

## Entity Description

### StudentEntry

This class represents the student data stored in the MongoDB collection.

Fields:

* id: Unique identifier (ObjectId)
* name: Name of the student
* rollNo: Unique roll number (indexed)
* marks: Marks obtained by the student
* date: Date and time when the entry is created

The roll number field is indexed as unique, which prevents duplicate entries in the database.

---

## API Endpoints

Add Student
POST /student

Get All Students
GET /student

Get Student by Roll Number
GET /student/roll/{rollNo}

Delete Student
DELETE /student/{id}

---

## How to Run the Project

1. Clone the repository
2. Open the project in IntelliJ IDEA
3. Make sure MongoDB is installed and running locally
4. Run the main Spring Boot application
5. Use Postman or browser to test APIs

---

## Database Information

* Database: MongoDB
* Collection: stdEntry

---

## Sample Request

{
"name": "Abhishek",
"rollNo": 101,
"marks": 85
}

---

## Future Improvements

* Add update functionality
* Add input validation
* Implement authentication and authorization
* Connect with frontend

---

## Author

Abhishek Nishad
BCA Student learning backend development with Java

---

## Note

This project is created for learning purposes and demonstrates basic CRUD operations using Spring Boot and MongoDB.
