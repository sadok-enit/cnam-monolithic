package com.cnam.internal.system.monolithicsystemapplication.model;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;

@Data
public class ClaimDto {

    private String numeroReclamation;
    private String libelle;
    private BigDecimal mntEngage;
    private BigDecimal mntReclame;
    private String motif;
    private Date date;
    private String observation;
    private long bulletinCode;
    private long numBordereauReclamation;
    private ClaimStatus status = ClaimStatus.PENDING;

}

