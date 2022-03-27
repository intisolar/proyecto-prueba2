package com.exams.createexams.model.entities;

import java.security.Timestamp;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Table(name = "USERS")
@Entity
@Getter
@Setter
public class User {

  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  @Column(name = "USER_ID", nullable = false, unique = true)
  private String userId;

  @Column(name = "FIRST_NAME", nullable = false)
  private String firstName;

  @Column(name = "LAST_NAME", nullable = false)
  private String lastName;

  @Column(name = "EMAIL", nullable = false, unique = true)
  private String email;

  @Column(name = "PASSWORD", nullable = false)
  private String password;

  @Column(name = "PHOTO", nullable = true)
  private String photo;

  @Column(name = "ROLE_ID")
  @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
  private List<Role> roles;


  @Column(name = "TIMESTAMP", nullable = false)
  private Timestamp timestamp;

  @Column(name = "SOFT_DELETE")
  private boolean softDelete;
}
