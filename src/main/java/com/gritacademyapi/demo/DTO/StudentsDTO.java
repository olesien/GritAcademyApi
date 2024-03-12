package com.gritacademyapi.demo.DTO;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class StudentsDTO {
    private Long id;
    private String town;
    private String hobby;
    private String fname;
    private String lname;
    private String email;
    private Integer phone;
    private String username;
}
