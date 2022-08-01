package com.exams.createexams.models.entities;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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
@Table(name = "UNIT")
public class Unit {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "UNIT_ID", nullable = false, unique = true)
  private Integer unitID;

  @OneToMany
  @JoinColumn(name = "EXAM_ID")
  private List<ExamTemplate> exams;

  @Column(name = "COMPLETE")
  private Boolean complete;

  /*Esta entidad guarda los exámenes por unidad. Recibe ExamTemplates en el caso de los cursos
   modelo y Exam en los casos de las copias de los cursos para efectivamente sean escritos por los
   alumnos. Más adelante se puede expandir con una descripción que contenga  los temas que abarca.*/
}
