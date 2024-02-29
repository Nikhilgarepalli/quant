package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Setter
@Getter
@Entity
@Table(name = "financialdata")
public class Finance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "ticker")
    private String ticker;
    @Column(name = "date")
    private Date date;
    @Column(name = "revenue")
    private Double revenue;
    @Column(name = "gp")
    private int gp;
    @Column(name = "fcf")
    private int fcf;
    @Column(name = "capex")
    private int capex;

}
