package com.exams.createexams.models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
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
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
public class Exam extends ExamTemplate{

  /*Puntaje final de los alumnos*/
  @Column(name = "FINAL_SCORE")
  private Float finalScore;
}
