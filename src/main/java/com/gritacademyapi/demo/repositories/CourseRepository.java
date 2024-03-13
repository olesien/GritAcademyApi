package com.gritacademyapi.demo.repositories;

import com.gritacademyapi.demo.entities.Courses;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends CrudRepository<Courses, Long> {
}
