package com.exams.createexams.repositories;

import com.exams.createexams.models.entities.Progress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProgressRepository extends JpaRepository<Progress, Long> {

}
