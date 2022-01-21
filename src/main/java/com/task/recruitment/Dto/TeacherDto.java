package com.task.recruitment.Dto;

import com.task.recruitment.Entity.Student;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Builder
@Getter
public class TeacherDto {

    private Long id;
    private String name;
    private String lastName;
    private int age;
    private String email;
    private String subjectOfTeaching;
    private List<Student> students = new ArrayList<>();
}
