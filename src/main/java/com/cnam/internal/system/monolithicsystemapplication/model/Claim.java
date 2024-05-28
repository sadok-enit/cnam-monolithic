


package com.cnam.internal.system.monolithicsystemapplication.model;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
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
    private Date date;

    @Column(name = "observation")
    private String observation;

    @Column(name = "bulletin_code")
    private long bulletinCode;

    @Column(name = "num_bordereau_reclamation")
    private long numBordereauReclamation;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private ClaimStatus status = ClaimStatus.PENDING;

}

