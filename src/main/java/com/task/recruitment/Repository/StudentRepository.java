package com.task.recruitment.Repository;

import com.task.recruitment.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByName(String name);
    List<Student> findByLastName(String lastName);
    List<Student> findAll(Pageable page);
    List<Student> findByTeachers_Id(Long id);

}
