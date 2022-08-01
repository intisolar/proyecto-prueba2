package com.exams.createexams.models.dtos.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaginationResponse {

  private int page;
  private int totalPages;
  private int size;
}
