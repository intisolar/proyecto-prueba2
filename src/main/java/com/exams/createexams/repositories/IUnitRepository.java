package com.exams.createexams.repositories;

import com.exams.createexams.models.entities.Unit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUnitRepository extends JpaRepository<Unit, Integer> {

}