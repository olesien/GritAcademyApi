package com.gritacademyapi.demo.services;

import com.gritacademyapi.demo.DTO.CoursesDTO;
import com.gritacademyapi.demo.DTO.StudentsDTO;
import com.gritacademyapi.demo.entities.Courses;
import com.gritacademyapi.demo.entities.Students;
import com.gritacademyapi.demo.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CourseService {

    @Autowired
    CourseRepository courseRepository;

    public List<Courses> getAllCourses() {
        List<Courses> courses = new ArrayList<>();
        courseRepository.findAll().iterator().forEachRemaining(courses::add);
       return courses;
    }

    public Optional<Courses> getCourseById(Long id) {
        return courseRepository.findById(id);
    }

    public CoursesDTO getCourseAndStudentsById(Long id) {
        Optional<Courses> course = courseRepository.findById(id);
        if (course.isPresent()) {
            return mapToDTO(course.get());
        } else {
            return null;
        }
    }

    private StudentsDTO mapToDTO(Students student) {
        StudentsDTO dto = new StudentsDTO();
        dto.setId(student.getId());
        dto.setTown(student.getTown());
        dto.setHobby(student.getHobby());
        dto.setFname(student.getFname());
        dto.setLname(student.getLname());

        return dto;
    }
    private CoursesDTO mapToDTO(Courses course) {
        CoursesDTO dto = new CoursesDTO();
        dto.setId(course.getId());
        dto.setName(course.getName());
        dto.setDescription(course.getDescription());
        dto.setYhp(course.getYhp());
        dto.setStudents(course.getStudents().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList()));
        return dto;
    }
}
