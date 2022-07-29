package com.exams.createexams.models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "EXAMS")
public class Exam extends ExamTemplate{

  @Column(name = "FINAL_SCORE")
  private Float finalScore;
}
