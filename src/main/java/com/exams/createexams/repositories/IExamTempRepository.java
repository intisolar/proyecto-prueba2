package com.exams.createexams.repositories;

import com.exams.createexams.models.entities.Exam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IExamTempRepository extends JpaRepository<Exam,Integer> {

}
