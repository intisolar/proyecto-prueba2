package com.exams.createexams.repositories;

import com.exams.createexams.models.entities.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudentRepository  extends JpaRepository<Student, String> {
  Page<Student> findBySoftDeleteFalseOrderByName(Pageable pageable);
}
