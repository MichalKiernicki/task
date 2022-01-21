package com.task.recruitment.Controller;

import com.task.recruitment.Dto.TeacherDto;
import com.task.recruitment.Mapper.TeacherMapper;
import com.task.recruitment.Entity.Teacher;
import com.task.recruitment.Service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class TeacherController {

    private final TeacherService teacherService;

    @GetMapping("/teachers")
    public List<TeacherDto> getTeachers(@RequestParam(required = false) Integer page, Sort.Direction sort) {
        int pageNumber = page != null && page >= 0 ? page : 0;
        Sort.Direction sortDirection = sort != null ? sort : Sort.Direction.ASC;
        return TeacherMapper.mapToTeacherDtos(teacherService.getTeachers(pageNumber, sortDirection));
    }

    @GetMapping("/teachers")
    public ResponseEntity<List<Teacher>> getTeachersByName(@RequestParam String name) {
        return new ResponseEntity<List<Teacher>>(teacherService.getTeacherByName(name), HttpStatus.OK);
    }

    @RequestMapping("/teachrs")
    public ResponseEntity<List<Teacher>> getTeachersByStudent(@RequestParam Long id) {
        return new ResponseEntity<List<Teacher>>(teacherService.getTeachersByStudent(id), HttpStatus.OK);
    }

    @GetMapping("/teacher")
    public ResponseEntity<List<Teacher>> getTeachersByLastName(@RequestParam String lastName) {
        return new ResponseEntity<List<Teacher>>(teacherService.getTeacherByLastName(lastName), HttpStatus.OK);
    }

    @PostMapping("/teachers")
    public Teacher addTeacher(@RequestBody Teacher teacher) {
        return teacherService.addTeacher(teacher);
    }

    @PutMapping("/teachers")
    public Teacher editTeacher(@RequestBody Teacher teacher) {
        return teacherService.editTeacher(teacher);
    }

    @DeleteMapping("/teachers/{id}")
    public void deleteTeacher(@PathVariable long id) {
        teacherService.deleteTeacher(id);
    }
}
