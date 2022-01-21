package com.task.recruitment.Dto;

import com.task.recruitment.Entity.Teacher;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
public class StudentDto {

    private Long id;
    private String name;
    private String lastName;
    private int age;
    private String email;
    private String subjectOfStudy;
    private List<Teacher> teachers = new ArrayList<>();
}
