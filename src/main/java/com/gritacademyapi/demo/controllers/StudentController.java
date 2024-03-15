package com.gritacademyapi.demo.controllers;

import com.gritacademyapi.demo.DTO.NewStudentDTO;
import com.gritacademyapi.demo.DTO.StudentsDTO;
import com.gritacademyapi.demo.entities.Students;
import com.gritacademyapi.demo.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;
    @GetMapping(value = "/students", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StudentsDTO>> students(@RequestParam Optional<String> fname, @RequestParam Optional<String> lname, @RequestParam Optional<String> town) {
        System.out.println("Getting students");
        //Check through the optional query parameters. If any are present we want to use these to query.
        if (fname.isPresent()) {
            //We want to search by fname
            return new ResponseEntity<>(studentService.getAllStudentsByFName(fname.get()), HttpStatus.OK);
        } else if (lname.isPresent()) {
            //We want to search by lname
            return new ResponseEntity<>(studentService.getAllStudentsByLName(lname.get()), HttpStatus.OK);
        } else if (town.isPresent()) {
            //We want to search by town
            return new ResponseEntity<>(studentService.getAllStudentsByTown(town.get()), HttpStatus.OK);
        }
        return new ResponseEntity<>(studentService.getAllStudents(), HttpStatus.OK);
    }

    @GetMapping(value = "/students/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StudentsDTO> student(@PathVariable Long id) {
        System.out.println("Getting student");
        StudentsDTO student = studentService.getStudentById(id);

        if (student != null) {
            return new ResponseEntity<>(student, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    }

    //Get a student with all their courses
    @GetMapping(value = "/students/{id}/courses", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StudentsDTO> studentWithCourses(@PathVariable Long id) {
        System.out.println("Getting student");
        StudentsDTO student = studentService.getStudentAndCoursesById(id);

        if (student != null) {
            return new ResponseEntity<>(student, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "/students", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StudentsDTO> createStudent(@RequestBody NewStudentDTO newStudent) {
        System.out.println("Adding student");
        StudentsDTO student = studentService.addStudent(newStudent);

        if (student != null) {
            return new ResponseEntity<>(student, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "/students/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> removeStudent(@PathVariable Long id) {
        System.out.println("Deleting student");
        boolean deleted = studentService.removeStudent(id);

        if (deleted) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
        }
    }
}
