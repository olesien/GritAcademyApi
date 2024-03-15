package com.gritacademyapi.demo.repositories;

import com.gritacademyapi.demo.entities.Students;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends CrudRepository<Students, Long> {
    List<Students> findAllByFname(String fName);
}
