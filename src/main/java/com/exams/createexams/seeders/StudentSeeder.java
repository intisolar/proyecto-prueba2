package com.exams.createexams.seeders;

import com.exams.createexams.models.entities.Student;
import com.exams.createexams.models.entities.User;
import com.exams.createexams.repositories.IStudentRepository;
import com.exams.createexams.repositories.IUserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
public class StudentSeeder implements CommandLineRunner {

  @Autowired
  private IStudentRepository studentRepository;
  @Autowired
  private IUserRepository userRepository;

  @Override
  @Order(3)
  public void run(String... args) throws Exception {
    seedStudentTable();
  }

  private void seedStudentTable() {
    if (studentRepository.count() == 0) {
      if (userRepository.count() !=0) {
        List<User> users = userRepository.findBySoftDeleteFalseOrderByFirstName();
        createActiveStudents(users);
        createInactiveStudent(users);
      }
    }
  }

  private void createActiveStudents(List<User> users) {

    int listSize = users.size() ;

    for (int i = 1; i < listSize; i++) {
      Student student = new Student();
      student.setSoftDelete(false);
      createStudent(users.get(i), student);
    }
  }

  private void createInactiveStudent(List<User> users) {
    Student student = new Student();
    student.setSoftDelete(true);
    createStudent(users.get(0), student);

  }

  private void createStudent(User user, Student student) {
    student.setUser(user);
    student.setName();
    studentRepository.save(student);
  }
}
