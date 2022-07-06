package com.example.diningreviews.domain;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;

import java.util.UUID;

@Data
@Builder
@Entity
public class Users extends AbstractPersistable<UUID> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "CITY")
    private String city;

    @Column(name = "STATE")
    private String state;

    @Column(name = "ZIP_CODE")
    private Integer zipCode;

    @Column(name = "INTERESTED_IN_PEANUT_ALLERGIES")
    private boolean interestedInPeanutAllergies;

    @Column(name = "INTERESTED_IN_EGG_ALLERGIES")
    private boolean interestedInEggAllergies;

    @Column(name = "INTERESTED_IN_DAIRY_ALLERGIES")
    private boolean interestedInDairyAllergies;

    public Users() {

    }

}
