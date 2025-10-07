package com.tournament.playso.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;


@Entity
@Data
@Table(name = "sport_facilities")
public class SportFacility {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String email;
    private String phone_number;
    private BigDecimal price;
    private String schedule;
    private String address;

    @ManyToOne
    @JoinColumn(name = "county_id", nullable = false)
    private County county;

    @ManyToOne
    @JoinColumn(name = "sportType_id", nullable = false)
    private SportType sportType;
}
