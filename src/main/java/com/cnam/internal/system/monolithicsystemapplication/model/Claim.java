package com.cnam.internal.system.monolithicsystemapplication.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "claims")
public class Claim {
    //missing attributes will be added later

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "numeroBSReclame")
    private String numeroReclamation;

    @Column(name = "libelle")
    private String libelle;

//    @Column(name = "mntEngage")
//    private BigDecimal mntEngage;

//    @Column(name = "mntReclame")
//    private BigDecimal mntReclame;

    @Column(name = "motif")
    private String motif;

    @Column(name = "date")
    private LocalDateTime date;

    @Column(name = "observation")
    private String observation;

    @Column(name = "bulletin_Code")
    private long bulletinCode;

//    @Column(name = "numBordereauReclamation")
//    private String numBordereauReclamation;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private ClaimStatus status = ClaimStatus.PENDING;

}
