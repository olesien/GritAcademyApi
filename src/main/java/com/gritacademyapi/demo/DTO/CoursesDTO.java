package com.gritacademyapi.demo.DTO;

import jakarta.annotation.Nullable;
import jakarta.persistence.Column;
import lombok.Data;

import java.util.List;

@Data
public class CoursesDTO {
    private Long id;
    private String name;
    private String description;
    private Integer yhp;
    List<StudentsDTO> students;
}