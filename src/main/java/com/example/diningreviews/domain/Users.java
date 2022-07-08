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
public class Users extends AbstractPersistable<UUID> {

    private String name;

    private String city;

    private String state;

    private Integer zipCode;

    @Column(columnDefinition = "boolean default false")
    private boolean interestedInPeanutAllergies;

    @Column(columnDefinition = "boolean default false")
    private boolean interestedInEggAllergies;

    @Column(columnDefinition = "boolean default false")
    private boolean interestedInDairyAllergies;

}
