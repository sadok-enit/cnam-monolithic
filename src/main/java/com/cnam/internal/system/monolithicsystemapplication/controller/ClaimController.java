package com.cnam.internal.system.monolithicsystemapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cnam.internal.system.monolithicsystemapplication.model.Claim;
import com.cnam.internal.system.monolithicsystemapplication.model.ClaimStatus;
import com.cnam.internal.system.monolithicsystemapplication.service.ClaimService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class ClaimController {

    @Autowired
    private ClaimService claimService;

    @GetMapping("/claims")
    public ResponseEntity<List<Claim>> getAllClaims() {
        return claimService.retrieveAllClaims();
    }

    @GetMapping("/claim/{id}")
    public ResponseEntity<Claim> getClaimById(@PathVariable(value = "id") Long claimId) {
        return claimService.retrieveClaimById(claimId);
    }

    @GetMapping("/claim-status/{id}")
    public ResponseEntity<ClaimStatus> getClaimStatus(@PathVariable(value = "id") Long claimId) {
        return claimService.retrieveClaimStatusById(claimId);
    }

}
