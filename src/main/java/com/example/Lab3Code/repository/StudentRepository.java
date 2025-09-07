package com.example.Lab3Code.repository;

import com.example.Lab3Code.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

// Spring maps the Student class to the corresponding DB table,
// and provides basic CRUD functionality through JPA(Java Persistence API)

// StudentRepository provides the following methods:
// - findAll() → retrieve all students
// - findById(id) → retrieve a student by ID
// - save(student) → insert or update a student
// - deleteById(id) → delete a student by ID

public interface StudentRepository extends JpaRepository<Student, Integer> {
}