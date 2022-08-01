package com.exams.createexams.models.dtos.response;

import com.exams.createexams.models.entities.Payment;
import com.exams.createexams.models.entities.Progress;
import com.exams.createexams.models.entities.User;
import java.sql.Timestamp;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentResponse {

  private String photo;
  /*This is a DTO that retrieves user and student data*/
  private String studentId;

  private String userID;

  private String name;

  private String email;

  private Timestamp timestamp;

  /*This reflects if they are currently active students not users*/
  private boolean studentSoftDelete;
}
