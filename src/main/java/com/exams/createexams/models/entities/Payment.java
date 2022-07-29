package com.exams.createexams.models.entities;

import java.sql.Date;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PAYMENTS")
public class Payment {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "PAYMENT_ID", nullable = false, unique = true)
  private Long paymentID;

  @ManyToOne
  @JoinColumn(name="STUDENT_ID", nullable=false)
  private Student student;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "COURSE_ID")
  private Course course;

//  @Column(name = "DUE_DATE")
//  @Temporal(TemporalType.DATE)
//  private Date dueDate;
//
//  @Column(name = "PAY_DAY")
//  @Temporal(TemporalType.DATE)
//  private Date payDay;

  @Column(name = "TRANSACTION_CODE")
  private String transactionCode;

  @Column(name = "TRANSACTION_TYPE")
  private String transType;

  @Column(name = "TIMESTAMP", nullable = false)
  @CreationTimestamp
  private Timestamp timestamps;

}
