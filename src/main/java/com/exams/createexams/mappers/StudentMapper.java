package com.exams.createexams.mappers;

import com.exams.createexams.models.dtos.response.StudentResponse;
import com.exams.createexams.models.entities.Student;
import com.exams.createexams.models.entities.User;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {

  public StudentResponse map(Student student, User user) {

    StudentResponse studentResponse = new StudentResponse();

    studentResponse.setPhoto(user.getPhoto());
    studentResponse.setStudentId(student.getStudentId());
    studentResponse.setUserID(user.getUserId());
    studentResponse.setName(student.getName());
    studentResponse.setEmail(user.getEmail());
    studentResponse.setTimestamp(student.getTimestamp());
    studentResponse.setStudentSoftDelete(student.isSoftDelete());

    return studentResponse;
  }

  public List<StudentResponse> map(List<Student> students) {
    List<StudentResponse> studentResponses = new ArrayList<>();

    for (Student student : students) {

      studentResponses.add(map(student, student.getUser()));
    }
    return studentResponses;
  }
}
