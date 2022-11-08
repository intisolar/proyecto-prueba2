package com.exams.createexams.controllers;

import com.exams.createexams.exception.student.StudentException;
import com.exams.createexams.models.entities.Student;
import com.exams.createexams.services.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentServiceImpl service;

    @PostMapping(path = "new")
    public void createStudent(@RequestBody(required = true) Student student) throws StudentException {
        service.save(student);
    }

    @PostMapping(path = "remove")
    public void removeStudent(@RequestBody(required = true) Student student) throws StudentException {
        service.remove(student);
    }




}
