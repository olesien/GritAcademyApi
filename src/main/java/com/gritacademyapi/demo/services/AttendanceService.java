package com.gritacademyapi.demo.services;

import com.gritacademyapi.demo.DTO.*;
import com.gritacademyapi.demo.entities.Attendance;
import com.gritacademyapi.demo.entities.Courses;
import com.gritacademyapi.demo.entities.Students;
import com.gritacademyapi.demo.repositories.AttendanceRepository;
import com.gritacademyapi.demo.repositories.CourseRepository;
import com.gritacademyapi.demo.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AttendanceService {

    @Autowired
    AttendanceRepository attendanceRepository;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    StudentRepository studentRepository;

    public List<AttendanceDTO> getAll() {
        List<AttendanceDTO> attendances = new ArrayList<>();
        attendanceRepository.findAll().iterator().forEachRemaining(attendant -> attendances.add(mapToDTO(attendant)));
       return attendances;
    }

    private CoursesDTO mapToDTO(Courses course) {
        CoursesDTO dto = new CoursesDTO();
        dto.setId(course.getId());
        dto.setName(course.getName());
        dto.setDescription(course.getDescription());
        dto.setYhp(course.getYhp());

        return dto;
    }

    public AttendanceDTO addAttendance(NewAttendanceDTO newAttendance) {
        Attendance attendance = new Attendance();
        Optional<Students> student = studentRepository.findById(newAttendance.getStudent_id());
        Optional<Courses> course = courseRepository.findById(newAttendance.getCourse_id());

        if (student.isPresent() && course.isPresent()) {
            attendance.setCourse(course.get());
            attendance.setStudent(student.get());
            Attendance addedAttendance = attendanceRepository.save(attendance);
            return mapToDTO(addedAttendance);
        }
        return null;
    }

    public boolean removeAttendance(Long id) {
        Optional<Attendance> attendance = attendanceRepository.findById(id);
        if (attendance.isPresent()) {
            attendanceRepository.delete(attendance.get());
            return true;
        } else {
            return false;
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

    private AttendanceDTO mapToDTO(Attendance attendance) {
        AttendanceDTO dto = new AttendanceDTO();
        dto.setId(attendance.getId());
        dto.setCourse(mapToDTO(attendance.getCourse()));
        dto.setStudent(mapToDTO(attendance.getStudent()));
        return dto;
    }
}
