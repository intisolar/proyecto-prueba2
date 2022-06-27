package com.exams.createexams.models.entities;

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

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "COURSE_FILES",
    joinColumns = @JoinColumn(name = "COURSE_ID", nullable = false),
    inverseJoinColumns = @JoinColumn(name = "FILE_ID"))
    private List<File> files;

    //Lista de precios para llevar un registro de los valores? REVISARR!!!!!!
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "COURSE_PRICES",
        joinColumns = @JoinColumn(name = "COURSE_ID"),
        inverseJoinColumns = @JoinColumn(name="PRICE_ID"))
    private List<Price> prices;

    @Column(name = "PAYMENT_TYPE")
    private String paymentType;

    @Column(name = "START_DATE")
    private Date startDate;

    @Column(name = "END_DATE")
    private Date endDate;

    @Column(name = "SOFT_DELETE")
    private boolean softDelete;
}
