package com.example.Lab3Code.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "student")
public class Student {
    @Id // 기본키
    @GeneratedValue(strategy = GenerationType.IDENTITY) // DB에서 auto-increment
    private Integer id; // type integer

    @Column(nullable = false, length = 100) // varchar(100) NOT NULL
    private String name;

    @Column(nullable = false) // Integer NOT NULL
    private Integer age;

}