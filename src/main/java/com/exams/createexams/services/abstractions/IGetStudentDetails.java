package com.exams.createexams.services.abstractions;

import com.exams.createexams.models.dtos.response.ListStudentResponse;
import org.springframework.data.domain.Pageable;

public interface IGetStudentDetails {

  ListStudentResponse findAllActive(Pageable pageable);

  ListStudentResponse findAll(Pageable pageable);
}
