package com.task.recruitment.Service;

import com.task.recruitment.Entity.Student;
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
public class StudentService {

    private static final int PAGE_SIZE = 20;
    private final StudentRepository studentRepository;
    private final TeacherRepository teacherRepository;

    public List<Student> getStudents(int page, Sort.Direction sort) {
        return studentRepository.findAll(
                (Pageable) PageRequest.of(page, PAGE_SIZE,
                        Sort.by(sort, "id")
                )
        );
    }

    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    @Transactional
    public Student editStudent(Student student) {
        Student studentEdited = studentRepository.findById(student.getId()).orElseThrow();
        studentEdited.setName(student.getName());
        studentEdited.setLastName(student.getLastName());
        studentEdited.setAge(student.getAge());
        studentEdited.setEmail(student.getEmail());
        studentEdited.setSubjectOfStudy(student.getSubjectOfStudy());
        studentEdited.setTeachers(student.getTeachers());
        return studentEdited;
    }

    public void deleteStudent(long id) {
        studentRepository.deleteById(id);
    }

    public List<Student> getStudentByName(String name) {
        return studentRepository.findByName(name);
    }

    public List<Student> getStudentByLastName(String lastName) {
        return studentRepository.findByLastName(lastName);
    }

    public List<Student> getStudentsByTeacher(Long id) {
        return studentRepository.findByTeachers_Id(id);
    }
}

