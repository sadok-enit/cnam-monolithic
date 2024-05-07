package com.cnam.internal.system.monolithicsystemapplication.model;

import java.math.BigDecimal;
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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "numero_bs_reclame")
    private String numeroReclamation;

    @Column(name = "libelle")
    private String libelle;

    @Column(name = "mnt_engage")
    private BigDecimal mntEngage;

    @Column(name = "mnt_reclame")
    private BigDecimal mntReclame;

    @Column(name = "motif")
    private String motif;

    @Column(name = "date")
    private LocalDateTime date;

    @Column(name = "observation")
    private String observation;

    @Column(name = "bulletin_code")
    private long bulletinCode;

    @Column(name = "num_bordereau_reclamation")
    private String numBordereauReclamation;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private ClaimStatus status = ClaimStatus.PENDING;

}
