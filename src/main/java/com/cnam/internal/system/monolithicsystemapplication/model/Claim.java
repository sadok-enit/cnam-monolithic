package com.cnam.internal.system.monolithicsystemapplication.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "claims")
public class Claim {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "claimer_name")
    private String title;

    @Column(name = "description")
    private String description;

    @Column
    private ClaimStatus status = ClaimStatus.PENDING;

}
