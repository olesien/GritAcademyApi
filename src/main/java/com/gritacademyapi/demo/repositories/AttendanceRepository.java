package com.gritacademyapi.demo.repositories;

import com.gritacademyapi.demo.entities.Attendance;
import com.gritacademyapi.demo.entities.Students;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendanceRepository extends CrudRepository<Attendance, Long> {
}
