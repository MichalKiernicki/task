package com.task.recruitment.Entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity(name="Student")
@Getter
@Setter
@Table(name="students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    @Size(min=2)
    private String name;

    @NotEmpty
    private String lastName;

    @Min(18)
    private int age;

    @Column(unique = true, nullable = false)
    @Email
    private String email;

    @NotEmpty
    private String subjectOfStudy;

    @ManyToMany(
            cascade = {CascadeType.MERGE, CascadeType.PERSIST}
    )
    @JoinTable(
            name = "students_teachers",
            joinColumns = @JoinColumn(name = "student_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "teacher_id",referencedColumnName = "id")
    )
    private List<Teacher> teachers = new ArrayList<>();

}
