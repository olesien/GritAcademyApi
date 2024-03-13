package com.gritacademyapi.demo.services;

import com.gritacademyapi.demo.DTO.CoursesDTO;
import com.gritacademyapi.demo.DTO.StudentsDTO;
import com.gritacademyapi.demo.entities.Courses;
import com.gritacademyapi.demo.entities.Students;
import com.gritacademyapi.demo.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public StudentsDTO getStudentAndCoursesById(Long id) {
        Optional<Students> student = studentRepository.findById(id);
        if (student.isPresent()) {
            return mapToDTO(student.get());
        } else {
            return null;
        }
    }

    private CoursesDTO mapToDTO(Courses course) {
        CoursesDTO dto = new CoursesDTO();
        dto.setId(course.getId());
        dto.setName(course.getName());
        dto.setDescription(course.getDescription());
        dto.setYhp(course.getYhp());

        return dto;
    }
    private StudentsDTO mapToDTO(Students student) {
        StudentsDTO dto = new StudentsDTO();
        dto.setId(student.getId());
        dto.setTown(student.getTown());
        dto.setHobby(student.getHobby());
        dto.setFname(student.getFname());
        dto.setLname(student.getLname());
        dto.setCourses(student.getCourses().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList()));
        return dto;
    }
}
