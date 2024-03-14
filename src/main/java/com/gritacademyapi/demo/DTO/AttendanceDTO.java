package com.gritacademyapi.demo.DTO;

import com.gritacademyapi.demo.entities.Courses;
import com.gritacademyapi.demo.entities.Students;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.util.List;

@Data
public class AttendanceDTO {
    private Long id;
    StudentsDTO student;
    CoursesDTO course;
}