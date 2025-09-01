package com.example.Lab3Code.controller;

import com.example.Lab3Code.model.Student;
import com.example.Lab3Code.repository.StudentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentRestController {

    private final StudentRepository repository;

    public StudentRestController(StudentRepository repository) {
        this.repository = repository;
    }

    //TODO: finish business logics!
}
