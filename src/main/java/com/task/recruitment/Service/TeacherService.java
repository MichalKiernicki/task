package com.task.recruitment.Service;

import com.task.recruitment.Entity.Teacher;
import com.task.recruitment.Repository.StudentRepository;
import com.task.recruitment.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.awt.print.Pageable;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {

    private static final int PAGE_SIZE = 20;
    private final TeacherRepository teacherRepository;
    private final StudentRepository studentRepository;

    public List<Teacher> getTeachers(int page, Sort.Direction sort) {
        return teacherRepository.findAll(
                (Pageable) PageRequest.of(page, PAGE_SIZE,
                        Sort.by(sort, "id")
                )
        );
    }

    public Teacher addTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @Transactional
    public Teacher editTeacher(Teacher teacher) {
        Teacher teacherEdited = teacherRepository.findById(teacher.getId()).orElseThrow();
        teacherEdited.setName(teacher.getName());
        teacherEdited.setLastName(teacher.getLastName());
        teacherEdited.setAge(teacher.getAge());
        teacherEdited.setEmail(teacher.getEmail());
        teacherEdited.setSubjectOfTeaching(teacher.getSubjectOfTeaching());
        teacherEdited.setStudents(teacher.getStudents());
        return teacherEdited;
    }

    public void deleteTeacher(long id) {
        teacherRepository.deleteById(id);
    }

    public List<Teacher> getTeacherByName(String name) {
        return teacherRepository.findByName(name);
    }

    public List<Teacher> getTeacherByLastName(String lastName) {
        return teacherRepository.findByLastName(lastName);
    }

    public List<Teacher> getTeachersByStudent(Long id) {
        return teacherRepository.findByStudents_Id(id);
    }

}
