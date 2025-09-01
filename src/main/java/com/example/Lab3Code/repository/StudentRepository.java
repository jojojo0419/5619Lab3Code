package com.example.Lab3Code.repository;

import com.example.Lab3Code.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}