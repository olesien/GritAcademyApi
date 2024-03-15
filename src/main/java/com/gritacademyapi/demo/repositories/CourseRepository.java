package com.gritacademyapi.demo.repositories;

import com.gritacademyapi.demo.entities.Courses;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CourseRepository extends CrudRepository<Courses, Long> {
    Optional<Courses> findByName(String name);

    Optional<Courses> findByNameContainingIgnoreCase(String name);

    Optional<Courses> findByDescriptionContainingIgnoreCase(String description);
}
