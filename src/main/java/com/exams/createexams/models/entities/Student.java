package com.exams.createexams.models.entities;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
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
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue
    private Long id;

    @JoinColumn(name = "user_id")
    @OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private User user;

    @Column(name = "course_id")
    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private List<Course> courses;

    @Column(name = "timestamp", nullable = false)
    @CreationTimestamp
    private LocalDate date;

    @Column(name = "soft_delete")
    private boolean softDelete;


}
