package com.gritacademyapi.demo.DTO;

import jakarta.persistence.Column;
import lombok.Data;

import java.util.List;

@Data
public class StudentsDTO {
    private Long id;
    private String town;
    private String hobby;
    private String fname;
    private String lname;
    List<CoursesDTO> courses;
}
