package com.task.recruitment.Controller;

import com.task.recruitment.Mapper.StudentMapper;
import com.task.recruitment.Entity.Student;
import com.task.recruitment.Dto.StudentDto;
import com.task.recruitment.Service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/students")
    public List<StudentDto> getStudents(@RequestParam(required = false) Integer page, Sort.Direction sort) {
        int pageNumber = page != null && page >= 0 ? page : 0;
        Sort.Direction sortDirection = sort != null ? sort : Sort.Direction.ASC;
        return StudentMapper.mapToStudentDtos(studentService.getStudents(pageNumber, sortDirection));
    }

    @GetMapping("/students")
    public ResponseEntity<List<Student>> getStudentsByName(@RequestParam String name) {
        return new ResponseEntity<List<Student>>(studentService.getStudentByName(name), HttpStatus.OK);
    }

    @GetMapping("/students")
    public ResponseEntity<List<Student>> getStudentByTeacher(@RequestParam Long id) {
        return new ResponseEntity<List<Student>>(studentService.getStudentsByTeacher(id), HttpStatus.OK);
    }

    @GetMapping("/students")
    public ResponseEntity<List<Student>> getStudentsByLastName(@RequestParam String lastName) {
        return new ResponseEntity<List<Student>>(studentService.getStudentByLastName(lastName), HttpStatus.OK);
    }

    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    @PutMapping("/students")
    public Student editStudent(@RequestBody Student student) {
        return studentService.editStudent(student);
    }

    @DeleteMapping("/students/{id}")
    public void deleteStudent(@PathVariable long id) {
        studentService.deleteStudent(id);
    }
}
