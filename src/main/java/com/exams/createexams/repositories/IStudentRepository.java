package com.exams.createexams.repositories;

import com.exams.createexams.models.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudentRepository  extends JpaRepository<Student, String> {

}
