package com.gritacademyapi.demo.services;

import com.gritacademyapi.demo.DTO.CoursesDTO;
import com.gritacademyapi.demo.DTO.NewCourseDTO;
import com.gritacademyapi.demo.DTO.NewStudentDTO;
import com.gritacademyapi.demo.DTO.StudentsDTO;
import com.gritacademyapi.demo.entities.Attendance;
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

    public List<CoursesDTO> getAllCourses() {
        List<CoursesDTO> courses = new ArrayList<>();
        courseRepository.findAll().iterator().forEachRemaining(course -> courses.add(mapToDTOBasic(course)));
       return courses;
    }

    public CoursesDTO getCourseById(Long id) {
        Optional<Courses> course = courseRepository.findById(id);
        if (course.isPresent()) {
            return mapToDTOBasic(course.get());
        } else {
            return null;
        }
    }

    public CoursesDTO getCourseAndStudentsById(Long id) {
        Optional<Courses> course = courseRepository.findById(id);
        if (course.isPresent()) {
            return mapToDTO(course.get());
        } else {
            return null;
        }
    }

    public CoursesDTO addCourse(NewCourseDTO newCourse) {
        Courses course = new Courses();
        course.setName(newCourse.getName());
        course.setDescription(newCourse.getDescription());
        course.setYhp(newCourse.getYhp());
        Courses addedCourse = courseRepository.save(course);
        return mapToDTO(addedCourse);
    }

    public boolean removeCourse(Long id) {
        Optional<Courses> course = courseRepository.findById(id);
        if (course.isPresent()) {
            courseRepository.delete(course.get());
            return true;
        } else {
            return false;
        }
    }

    private StudentsDTO mapToDTO(Attendance student) {
        StudentsDTO dto = new StudentsDTO();
        dto.setId(student.getId());
        dto.setTown(student.getStudent().getTown());
        dto.setHobby(student.getStudent().getHobby());
        dto.setFname(student.getStudent().getFname());
        dto.setLname(student.getStudent().getLname());

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

    private CoursesDTO mapToDTOBasic(Courses course) {
        CoursesDTO dto = new CoursesDTO();
        dto.setId(course.getId());
        dto.setName(course.getName());
        dto.setDescription(course.getDescription());
        dto.setYhp(course.getYhp());
        return dto;
    }
}
