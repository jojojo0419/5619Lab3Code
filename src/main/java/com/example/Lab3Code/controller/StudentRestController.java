package com.example.Lab3Code.controller;

import com.example.Lab3Code.model.Student;
import com.example.Lab3Code.repository.StudentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController // Marks this class as a REST API controller
@RequestMapping("/api/students") // All endpoints here will start with /api/students 🔥
public class StudentRestController {

    // Inject the StudentRepository through constructor
    private final StudentRepository repository;

    public StudentRestController(StudentRepository repository) {
        this.repository = repository;
    }

    // -------------------------------
    // GET /api/students
    // Returns a list of all students
    // -------------------------------
    @GetMapping
    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    // -------------------------------
    // POST /api/students
    // Creates a new student
    // Returns the saved student object with status 201 Created
    // -------------------------------
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(@RequestBody Student student) {
        return repository.save(student);
    }

    // -------------------------------
    // PUT /api/students/{id}
    // Updates the student with the given ID
    // Returns the updated student object
    // If the student is not found, throws 404 Not Found
    // -------------------------------
    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Integer id, @RequestBody Student updated) {
        return repository.findById(id)
                .map(student -> {
                    student.setName(updated.getName());
                    student.setAge(updated.getAge());
                    return repository.save(student);
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found"));
    }

    // -------------------------------
    // DELETE /api/students/{id}
    // Deletes the student with the given ID
    // If not found, throws 404 Not Found
    // Returns 204 No Content on success
    // -------------------------------
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteStudent(@PathVariable Integer id) {
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found");
        }
        repository.deleteById(id);
    }

}
