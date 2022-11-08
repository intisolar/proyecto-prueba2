package com.exams.createexams.services.abstractions;

import com.exams.createexams.exception.student.StudentException;
import com.exams.createexams.models.entities.Student;

import java.time.LocalDate;

/**
 * Every time a student is saved, modified, or removed, a new time is setted.
 */
public interface IStudentService {

    /**
     * @param student
     * @throws StudentException
     */
    void save(Student student) throws StudentException;

    void remove(Student student) throws StudentException;

    void activate(Student student) throws StudentException;

}
