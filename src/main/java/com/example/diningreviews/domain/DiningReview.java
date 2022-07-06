package com.example.diningreviews.domain;


import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
public class DiningReview {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID Id;

    @Column(name = "PEANUT_SCORE")
    private Integer peanutScore;

    @Column(name = "EGG_SCORE")
    private Integer eggScore;

    @Column(name = "DAIRY_SCORE")
    private Integer dairyScore;

    @Column(name = "COMMENTARY")
    private String commentary;

    @Enumerated(EnumType.STRING)
    private Status status;
}

