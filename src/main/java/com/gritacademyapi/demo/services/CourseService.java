package com.gritacademyapi.demo.services;

import com.gritacademyapi.demo.entities.Courses;
import com.gritacademyapi.demo.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
}
