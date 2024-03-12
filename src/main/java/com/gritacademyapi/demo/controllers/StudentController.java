package com.gritacademyapi.demo.controllers;

import com.gritacademyapi.demo.entities.Students;
import com.gritacademyapi.demo.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;
    @GetMapping(value = "/students", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Students>> students() {
        System.out.println("Getting students");
        return new ResponseEntity<>(studentService.getAllStudents(), HttpStatus.OK);
    }
}
