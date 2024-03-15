package com.gritacademyapi.demo.controllers;

import com.gritacademyapi.demo.DTO.AttendanceDTO;
import com.gritacademyapi.demo.DTO.CoursesDTO;
import com.gritacademyapi.demo.DTO.NewAttendanceDTO;
import com.gritacademyapi.demo.DTO.NewCourseDTO;
import com.gritacademyapi.demo.entities.Attendance;
import com.gritacademyapi.demo.entities.Students;
import com.gritacademyapi.demo.services.AttendanceService;
import com.gritacademyapi.demo.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AttendanceController {
    @Autowired
    private AttendanceService attendanceService;
    @GetMapping(value = "/attendance", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AttendanceDTO>> all() {
        System.out.println("Getting attendance");
        return new ResponseEntity<>(attendanceService.getAll(), HttpStatus.OK);
    }

    @PostMapping(value = "/attendance", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AttendanceDTO> createStudent(@RequestBody NewAttendanceDTO newAttendance) {
        System.out.println("Adding attendance");
        AttendanceDTO attendance = attendanceService.addAttendance(newAttendance);

        if (attendance != null) {
            return new ResponseEntity<>(attendance, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
