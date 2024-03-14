package com.gritacademyapi.demo.controllers;

import com.gritacademyapi.demo.DTO.AttendanceDTO;
import com.gritacademyapi.demo.entities.Attendance;
import com.gritacademyapi.demo.entities.Students;
import com.gritacademyapi.demo.services.AttendanceService;
import com.gritacademyapi.demo.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
}
