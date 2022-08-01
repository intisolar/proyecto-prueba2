package com.exams.createexams.models.entities;

import java.sql.Timestamp;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

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

  @OneToOne
  @JoinColumn(name = "STUDENT_ID")
  private Student student;

  @OneToOne
  @JoinColumn(name = "COURSE_ID")
  private Course course;

  @OneToMany(fetch = FetchType.LAZY)
  @Column(name = "EXAMS")
  private List<Exam> exams;

  @Column(name = "PROGRESS_PERCENTAGE")
  private Float progressPercentage;

  @Column(name = "TIMESTAMP", nullable = false)
  @CreationTimestamp
  private Timestamp timestamps;


}
