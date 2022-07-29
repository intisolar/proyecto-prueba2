package com.exams.createexams.models.entities;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "PROGRESS")
public class Progress {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "PROGRESS_ID", nullable = false, unique = true)
  private Long progressID;

  @Column(name = "STUDENTS")
  private Student student;

  @Column(name = "COURSES")
  private Course course;

  @Column(name = "EXAMS")
  private List<Exam> exams;

  @Column(name = "PROGRESS_PERCENTAGE")
  private Float progressPercentage;

}
