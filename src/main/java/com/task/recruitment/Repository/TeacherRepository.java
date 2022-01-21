package com.task.recruitment.Repository;

import com.task.recruitment.Entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    List<Teacher> findByName(String name);
    List<Teacher> findByLastName(String lastName);
    List<Teacher> findAll(Pageable page);
    List<Teacher> findByStudents_Id(Long id);
}
