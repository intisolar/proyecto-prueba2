package com.exams.createexams.controllers;

import com.exams.createexams.common.PaginateResultsRetrieved;
import com.exams.createexams.models.dtos.response.ListStudentResponse;
import com.exams.createexams.services.abstractions.IGetStudentDetails;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/students")
public class StudentController {

  private static final String STUDENTS_PATH = "/students";
  private static final String ACTIVE_STUDENT_PATH = "/active";

  @Autowired
  private IGetStudentDetails getStudentDetails;

  @Autowired
  private PaginateResultsRetrieved resultsRetrieved;


  @GetMapping
  public ResponseEntity<ListStudentResponse> list(Pageable pageable,
      UriComponentsBuilder uriBuilder, HttpServletResponse response){
    ListStudentResponse listStudentResponse = getStudentDetails.findAll(pageable);
    resultsRetrieved.addLinkHeaderOnPagedResourceRetrieval(uriBuilder,
        response,
        STUDENTS_PATH,
        listStudentResponse.getPage(),
        listStudentResponse.getTotalPages(),
        listStudentResponse.getSize());
    return ResponseEntity.ok().body(listStudentResponse);
  }
  @GetMapping("/active")
  public ResponseEntity<ListStudentResponse> listActive(Pageable pageable,
      UriComponentsBuilder uriBuilder, HttpServletResponse response){
    ListStudentResponse listStudentResponse = getStudentDetails.findAllActive(pageable);
    resultsRetrieved.addLinkHeaderOnPagedResourceRetrieval(uriBuilder,
        response,
        STUDENTS_PATH+ACTIVE_STUDENT_PATH,
        listStudentResponse.getPage(),
        listStudentResponse.getTotalPages(),
        listStudentResponse.getSize());
    return ResponseEntity.ok().body(listStudentResponse);
  }
}
