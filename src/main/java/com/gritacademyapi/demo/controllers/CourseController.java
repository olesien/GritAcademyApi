package com.gritacademyapi.demo.controllers;

import com.gritacademyapi.demo.DTO.CoursesDTO;
import com.gritacademyapi.demo.DTO.NewCourseDTO;
import com.gritacademyapi.demo.DTO.NewStudentDTO;
import com.gritacademyapi.demo.DTO.StudentsDTO;
import com.gritacademyapi.demo.entities.Courses;
import com.gritacademyapi.demo.entities.Students;
import com.gritacademyapi.demo.services.CourseService;
import com.gritacademyapi.demo.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    //Get a course with all its students by name
    @GetMapping(value = "/course_by_name/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CoursesDTO> courseWithStudentsByName(@PathVariable String name) {
        System.out.println("Getting course with students by name");
        CoursesDTO course = courseService.getCourseAndStudentsByName(name);

        if (course != null) {
            return new ResponseEntity<>(course, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/course_matching_name/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CoursesDTO> courseWithStudentsMatchingName(@PathVariable String name) {
        System.out.println("Getting course with students matching name");
        CoursesDTO course = courseService.getCourseAndStudentsMatchingName(name);

        if (course != null) {
            return new ResponseEntity<>(course, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/course_matching_description/{description}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CoursesDTO> courseWithStudentsMatchingDescription(@PathVariable String description) {
        System.out.println("Getting course with students matching description");
        CoursesDTO course = courseService.getCourseAndStudentsMatchingDescription(description);

        if (course != null) {
            return new ResponseEntity<>(course, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "/courses", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CoursesDTO> createStudent(@RequestBody NewCourseDTO newCourse) {
        System.out.println("Adding course");
        CoursesDTO course = courseService.addCourse(newCourse);

        if (course != null) {
            return new ResponseEntity<>(course, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping(value = "/courses/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> removeCourse(@PathVariable Long id) {
        System.out.println("Deleting course");
        boolean deleted = courseService.removeCourse(id);

        if (deleted) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
        }
    }
}
