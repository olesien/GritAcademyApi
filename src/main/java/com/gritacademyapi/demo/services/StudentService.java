package com.gritacademyapi.demo.services;

import com.gritacademyapi.demo.DTO.CoursesDTO;
import com.gritacademyapi.demo.DTO.NewStudentDTO;
import com.gritacademyapi.demo.DTO.StudentsDTO;
import com.gritacademyapi.demo.entities.Attendance;
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

    public List<StudentsDTO> getAllStudents() {
        List<StudentsDTO> students = new ArrayList<>();
       studentRepository.findAll().iterator().forEachRemaining(student -> students.add(mapToDTOBasic(student)));
       return students;
    }

    public List<StudentsDTO> getAllStudentsByFName(String fname) {
        List<StudentsDTO> students = new ArrayList<>();
        studentRepository.findAllByFname(fname).iterator().forEachRemaining(student -> students.add(mapToDTO(student)));
        return students;
    }

    public List<StudentsDTO> getAllStudentsByLName(String lname) {
        List<StudentsDTO> students = new ArrayList<>();
        studentRepository.findAllByLname(lname).iterator().forEachRemaining(student -> students.add(mapToDTO(student)));
        return students;
    }

    public List<StudentsDTO> getAllStudentsByTown(String town) {
        List<StudentsDTO> students = new ArrayList<>();
        studentRepository.findAllByTown(town).iterator().forEachRemaining(student -> students.add(mapToDTO(student)));
        return students;
    }

    public StudentsDTO getStudentById(Long id) {
        Optional<Students> student = studentRepository.findById(id);
        if (student.isPresent()) {
            return mapToDTOBasic(student.get());
        } else {
            return null;
        }

    }

    public StudentsDTO getStudentAndCoursesById(Long id) {
        Optional<Students> student = studentRepository.findById(id);
        if (student.isPresent()) {
            return mapToDTO(student.get());
        } else {
            return null;
        }
    }

    public StudentsDTO addStudent(NewStudentDTO newStudent) {
        Students student = new Students();
        student.setFname(newStudent.getFname());
        student.setLname(newStudent.getLname());
        student.setTown(newStudent.getTown());
        student.setHobby(newStudent.getHobby());
        student.setEmail(newStudent.getEmail());
        student.setUsername(newStudent.getFname());
        student.setPhone("000");
        Students addedStudent = studentRepository.save(student);
        return mapToDTO(addedStudent);
    }

    public boolean removeStudent(Long id) {
        Optional<Students> student = studentRepository.findById(id);
        if (student.isPresent()) {
            studentRepository.delete(student.get());
            return true;
        } else {
            return false;
        }
    }

    private CoursesDTO mapToDTO(Attendance course) {
        CoursesDTO dto = new CoursesDTO();
        dto.setId(course.getCourse().getId());
        dto.setName(course.getCourse().getName());
        dto.setDescription(course.getCourse().getDescription());
        dto.setYhp(course.getCourse().getYhp());

        return dto;
    }

    private StudentsDTO mapToDTOBasic(Students student) {
        StudentsDTO dto = new StudentsDTO();
        dto.setId(student.getId());
        dto.setTown(student.getTown());
        dto.setHobby(student.getHobby());
        dto.setFname(student.getFname());
        dto.setLname(student.getLname());
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
