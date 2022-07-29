package com.exams.createexams.models.entities;

import java.sql.Timestamp;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
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
@Table(name = "STUDENTS")
public class Student {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "STUDENT_ID", nullable = false, unique = true)
    private String studentId;

    @JoinColumn(name = "USER_ID")
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private User user;

    /*Instead of having courses students have progress. Progress saves the course*/
    @Column(name = "PROGRESS_ID")
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Progress> coursesProgress;

    @Column(name = "PAYMENT_ID")
    @OneToMany(fetch = FetchType.LAZY, mappedBy="student")
    private List<Payment> payments;

    @Column(name = "TIMESTAMP", nullable = false)
    @CreationTimestamp
    private Timestamp timestamp;

    @Column(name = "SOFT_DELETE")
    private boolean softDelete;


}
