package com.exams.createexams.services;

import com.exams.createexams.mappers.StudentMapper;
import com.exams.createexams.models.dtos.response.ListStudentResponse;
import com.exams.createexams.models.dtos.response.StudentResponse;
import com.exams.createexams.models.entities.Student;
import com.exams.createexams.repositories.IStudentRepository;
import com.exams.createexams.services.abstractions.IGetStudentDetails;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class StudentService implements IGetStudentDetails {

  @Autowired
  private IStudentRepository studentRepository;

  @Autowired
  private StudentMapper studentMapper;

  @Override
  public ListStudentResponse findAllActive(Pageable pageable) {

    Page<Student> page = studentRepository.findBySoftDeleteFalseOrderByName(pageable);
    List<StudentResponse> studentResponses = studentMapper.map(page.getContent());

    return buildListResponse(studentResponses,page);
  }

  @Override
  public ListStudentResponse findAll(Pageable pageable) {
    Page<Student> page = studentRepository.findAll(pageable);
    List<StudentResponse> studentResponses = studentMapper.map(page.getContent());

    return buildListResponse(studentResponses,page);
  }

 private ListStudentResponse buildListResponse (List<StudentResponse> studentResponses,
     Page<Student> page){
    ListStudentResponse listStudentResponse = new ListStudentResponse();
    listStudentResponse.setStudentResponses(studentResponses);
    listStudentResponse.setPage(page.getNumber());
    listStudentResponse.setSize(page.getSize());
    listStudentResponse.setTotalPages(page.getTotalPages());
    return listStudentResponse;
 }
}
