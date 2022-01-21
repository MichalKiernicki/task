package com.task.recruitment.Mapper;

import com.task.recruitment.Dto.TeacherDto;
import com.task.recruitment.Entity.Teacher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeacherMapper {

    public static List<TeacherDto> mapToTeacherDtos(List<Teacher> teachers) {
        return teachers.stream()
                .map(teacher -> mapToTeacherDto(teacher))
                .collect(Collectors.toList());
    }
    public static TeacherDto mapToTeacherDto(Teacher teacher) {
        return TeacherDto.builder()
                .id(teacher.getId())
                .name(teacher.getName())
                .lastName(teacher.getLastName())
                .age(teacher.getAge())
                .email(teacher.getEmail())
                .subjectOfTeaching(teacher.getSubjectOfTeaching())
                .students(teacher.getStudents())
                .build();
    }
}
