package com.example.Lab3Code.controller;

import com.example.Lab3Code.model.Student;
import com.example.Lab3Code.repository.StudentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController // REST API 컨트롤러 선언
@RequestMapping("/api/students") // /api/students로 시작하는 요청 처리 🔥
public class StudentRestController {

    // StudentRepository 에서 만든거 이렇게 씀
    private final StudentRepository repository;

    public StudentRestController(StudentRepository repository) {
        this.repository = repository;
    }

    // DONE: finish business logics!
    // GET => /students
    // POST => /students
    // PUT => /students/{id}
    // DELETE => /students/{id}

    @GetMapping
    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(@RequestBody Student student) {
        return repository.save(student);
    }

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

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteStudent(@PathVariable Integer id) {
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found");
        }
        repository.deleteById(id);
    }

}
