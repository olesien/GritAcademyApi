package com.gritacademyapi.demo.services;

import com.gritacademyapi.demo.entities.Students;
import com.gritacademyapi.demo.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public List<Students> getAllStudents() {
        List<Students> students = new ArrayList<>();
       studentRepository.findAll().iterator().forEachRemaining(students::add);
       return students;
    }

    public Optional<Students> getStudentById(Long id) {
        return studentRepository.findById(id);

    }
}
