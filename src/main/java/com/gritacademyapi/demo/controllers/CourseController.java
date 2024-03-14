package com.gritacademyapi.demo.controllers;

import com.gritacademyapi.demo.DTO.CoursesDTO;
import com.gritacademyapi.demo.DTO.StudentsDTO;
import com.gritacademyapi.demo.entities.Courses;
import com.gritacademyapi.demo.entities.Students;
import com.gritacademyapi.demo.services.CourseService;
import com.gritacademyapi.demo.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class CourseController {
    @Autowired
    private CourseService courseService;
    @GetMapping(value = "/courses", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CoursesDTO>> courses() {
        System.out.println("Getting courses");
        return new ResponseEntity<>(courseService.getAllCourses(), HttpStatus.OK);
    }

    @GetMapping(value = "/courses/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CoursesDTO> course(@PathVariable Long id) {
        System.out.println("Getting course");
        CoursesDTO course = courseService.getCourseById(id);

        if (course != null) {
            return new ResponseEntity<>(course, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    }
    //Get a course with all its students
    @GetMapping(value = "/courses/{id}/students", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CoursesDTO> courseWithStudents(@PathVariable Long id) {
        System.out.println("Getting course with students");
        CoursesDTO course = courseService.getCourseAndStudentsById(id);

        if (course != null) {
            return new ResponseEntity<>(course, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    }
}
