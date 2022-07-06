package com.example.diningreviews.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "OVERALL_AVERAGE")
    private Integer overallAverage;

    @Column(name = "PEANUT_AVERAGE")
    private Integer peanutAverage;

    @Column(name = "EGG_AVERAGE")
    private Integer eggAverage;

    @Column(name = "DAIRY_AVERAGE")
    private Integer dairyAverage;
}
