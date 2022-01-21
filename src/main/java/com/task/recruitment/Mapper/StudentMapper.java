package com.task.recruitment.Mapper;

import com.task.recruitment.Dto.StudentDto;
import com.task.recruitment.Entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentMapper {

    private StudentMapper(){

    }

    public static List<StudentDto> mapToStudentDtos(List<Student> students) {
        return students.stream()
                .map(student -> mapToStudentDto(student))
                .collect(Collectors.toList());
    }
    public static StudentDto mapToStudentDto(Student student) {
        return StudentDto.builder()
                .id(student.getId())
                .name(student.getName())
                .lastName(student.getLastName())
                .age(student.getAge())
                .email(student.getEmail())
                .subjectOfStudy(student.getSubjectOfStudy())
                .teachers(student.getTeachers())
                .build();
    }
}
