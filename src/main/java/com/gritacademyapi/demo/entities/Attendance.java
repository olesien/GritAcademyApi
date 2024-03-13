package com.gritacademyapi.demo.entities;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity(name = "attendance")
@Table(name = "attendance")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Attendance {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "student_id")
    private Long student_id;
    @Column(name = "course_id")
    private Long course_id;



}
