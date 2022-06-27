package com.exams.createexams.models.entities;

import java.sql.Date;
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
@Table(name = "PRICES")
public class Price {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRICE_ID", nullable = false, unique = true)
    private Long priceId;

    @Column(name = "PRICE")
    private Double price;

    @Column(name = "SOFT_DELETE")
    private boolean softDelete;
    ///Fecha inicio // fecha final // sin tipo de curso
    @Column(name = "START_DATE")
    //   @Temporal(TemporalType.DATE)
    private Date startDate;

    @Column(name = "END_DATE")
    //   @Temporal(TemporalType.DATE)
    private Date endDate;


}
