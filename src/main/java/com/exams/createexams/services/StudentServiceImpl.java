package com.exams.createexams.services;

import com.exams.createexams.exception.student.StudentException;
import com.exams.createexams.models.entities.Student;
import com.exams.createexams.repositories.IStudentRepository;
import com.exams.createexams.services.abstractions.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    private IStudentRepository repository;


    @Override
    public void save(Student student) throws StudentException {
        Student st = repository.getById(student.getId());

        if (st.equals(null) || st.equals(new Student())) {
            st = student;
        }

        repository.save(st);
    }


    @Override
    public void remove(Student student) throws StudentException {

        Student st = repository.getById(student.getId());
        if (st.isSoftDelete()) {
            st.setSoftDelete(false);
            st.setDate(LocalDate.now());
        }
        repository.save(st);
    }

    @Override
    public void activate(Student student) throws StudentException {
        Student st = repository.getById(student.getId());
        if (!st.isSoftDelete()) {
            st.setSoftDelete(true);
            st.setDate(LocalDate.now());
        }
    }
}
