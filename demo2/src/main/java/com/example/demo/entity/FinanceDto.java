package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class FinanceDto {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private Long id;

        //@Column(name = "ticker")
        //private String ticker;
        //@Column(name = "date")
        // Date date;
        @Column(name = "revenue")
        private Double revenue;
        @Column(name = "gp")
        private double gp;

}
