package com.cnam.internal.system.monolithicsystemapplication.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "retenu_facture")
public class RetenuFacture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "code")
    private long code;

    @Column(name = "matricule")
    private long matricule;

    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "departement")
    private String departement;

    @Column(name = "date_soin")
    private LocalDateTime dateSoin;

    @Column(name = "n_bordereau")
    private long numeroBordereau;

    @Column(name = "etablissements_conventionnes")
    private String etablissementsConventionnes;

    @Column(name = "b_recu")
    private String bRecu;

    @Column(name = "montant")
    private BigDecimal montant;

    @Column(name = "motif")
    private String motif;
}
