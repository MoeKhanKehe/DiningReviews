package com.example.diningreviews.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class DiningReview extends AbstractPersistable<UUID> {

    @Column(name = "REVIEWER")
    private String reviewer;

    @Column(name = "RESTAURANT_NAME")
    private String restaurantName;

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

