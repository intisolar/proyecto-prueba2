package com.exams.createexams.models.entities;

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
@Table(name = "EXAM_TEMPLATES")
public class ExamTemplate {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "EXAM_TEMPLATE_ID", nullable = false, unique = true)
  private Integer examTemplateId;

  @Column(name = "SCORE")
  private Integer score;

  @Column(name = "SOFT_DELETE")
  private Boolean softDelete;


}
