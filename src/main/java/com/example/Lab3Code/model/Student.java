package com.example.Lab3Code.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "student")
public class Student {
    @Id // Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment
    private Integer id;

    @Column(nullable = false, length = 100) // Not null, max length 100
    private String name;

    @Column(nullable = false) // Not null
    private Integer age;

}