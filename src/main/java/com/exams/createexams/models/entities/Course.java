package com.exams.createexams.models.entities;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@Table(name = "COURSES")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COURSE_ID", nullable = false, unique = true)
    private Long courseId;

    @Column(name = "STAGE", nullable = true)
    private Integer stage;

    @Column(name = "LEVEL", nullable = false)
    private String level;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "TYPE")
    private String type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SUBJECT_ID")
    private Subject subject;

    @ManyToMany(fetch = FetchType.LAZY) //Files can exist independently.
    @JoinTable(name = "COURSE_FILES",
    joinColumns = @JoinColumn(name = "COURSE_ID", nullable = false),
    inverseJoinColumns = @JoinColumn(name = "FILE_ID"))
    private List<File> files;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "UNIT_ID")
    private List<Unit> units;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "COURSE_PRICES",
        joinColumns = @JoinColumn(name = "COURSE_ID"),
        inverseJoinColumns = @JoinColumn(name="PRICE_ID"))
    private List<Price> prices;

    /* Enum PaymentType */
    @Column(name = "PAYMENT_TYPE")
    private String paymentType;

    @Column(name = "START_DATE")
    private Date startDate;

    @Column(name = "END_DATE")
    private Date endDate;

    @Column(name = "TIMESTAMP", nullable = false)
    @CreationTimestamp
    private Timestamp timestamps;


    @Column(name = "SOFT_DELETE")
    private boolean softDelete;
}
