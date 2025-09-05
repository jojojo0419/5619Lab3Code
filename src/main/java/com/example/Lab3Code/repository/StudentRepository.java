package com.example.Lab3Code.repository;

import com.example.Lab3Code.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

// Spring 이 Student 클래스와 연결되 DB테이블에 매핑, 기본적인 CRUD 가능
// JPA = Java Persistence API
public interface StudentRepository extends JpaRepository<Student, Integer> {
}