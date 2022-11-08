package com.exams.createexams.models.dtos.response;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ListStudentResponse extends PaginationResponse {

  private List<StudentResponse> studentResponses;
}
