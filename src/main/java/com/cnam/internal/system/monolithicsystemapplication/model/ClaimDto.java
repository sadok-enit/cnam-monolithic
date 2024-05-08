package com.cnam.internal.system.monolithicsystemapplication.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ClaimDto {

    private String numeroReclamation;
    private String libelle;
    private BigDecimal mntEngage;
    private BigDecimal mntReclame;
    private String motif;
    private LocalDateTime date;
    private String observation;
    private long bulletinCode;
    private String numBordereauReclamation;
    private ClaimStatus status = ClaimStatus.PENDING;

}
