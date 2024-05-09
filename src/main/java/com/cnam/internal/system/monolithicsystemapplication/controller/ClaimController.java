package com.cnam.internal.system.monolithicsystemapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cnam.internal.system.monolithicsystemapplication.model.Claim;
import com.cnam.internal.system.monolithicsystemapplication.model.ClaimDto;
import com.cnam.internal.system.monolithicsystemapplication.model.ClaimStatus;
import com.cnam.internal.system.monolithicsystemapplication.service.ClaimService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class ClaimController {

    @Autowired
    private ClaimService claimService;

    /**
     * Retrieves all claims.
     *
     * @return ResponseEntity with list of claims
     */
    @GetMapping("/claims")
    public ResponseEntity<List<Claim>> getAllClaims() {
        return claimService.retrieveAllClaims();
    }

    /**
     * Retrieves a claim by ID.
     *
     * @param claimId The ID of the claim to retrieve
     * @return ResponseEntity with the retrieved claim
     */
    @GetMapping("/claim/{id}")
    public ResponseEntity<Claim> getClaimById(@PathVariable(value = "id") Long claimId) {
        return claimService.retrieveClaimById(claimId);
    }

    /**
     * Retrieves the status of a claim by ID.
     *
     * @param claimId The ID of the claim
     * @return ResponseEntity with the claim status
     */
    @GetMapping("/claim-status/{id}")
    public ResponseEntity<ClaimStatus> getClaimStatus(@PathVariable(value = "id") Long claimId) {
        return claimService.retrieveClaimStatusById(claimId);
    }

    /**
     * Adds a new claim.
     *
     * @param claimDto The claim object to add
     * @return ResponseEntity with the added claim
     */
    @PostMapping("/claim")
    public ResponseEntity<Claim> addClaim(@RequestBody ClaimDto claimDto) {
        Claim savedClaim = claimService.addClaim(claimDto);
        return ResponseEntity.ok().body(savedClaim);
    }

    /**
     * Deletes a claim by ID.
     *
     * @param claimId The ID of the claim to delete
     * @return ResponseEntity indicating success or failure
     */
    @DeleteMapping("/claim/{id}")
    public ResponseEntity<Void> deleteClaim(@PathVariable(value = "id") Long claimId) {
        claimService.deleteClaimById(claimId);
        return ResponseEntity.noContent().build();
    }

    /**
     * Update a Claim by ID.
     *
     * @param claimId      The ID of the Claim to update.
     * @param updatedClaim The updated Claim object.
     * @return ResponseEntity with the updated Claim.
     */
    @PutMapping("/claim/{id}")
    public ResponseEntity<Claim> updateClaim(@PathVariable(value = "id") Long claimId, @RequestBody ClaimDto updatedClaim) {
        Claim claim = claimService.updateClaim(claimId, updatedClaim);
        return ResponseEntity.ok().body(claim);
    }

    /**
     * Modifies the status of a claim by ID.
     *
     * @param claimId   The ID of the claim to modify
     * @param newStatus The new status for the claim
     * @return ResponseEntity with the modified claim
     */

    @PutMapping("/claim/{id}/status")
    public ResponseEntity<Claim> updateClaimStatus(@PathVariable(value = "id") Long claimId, @RequestParam ClaimStatus newStatus) {
        Claim updatedClaim = claimService.updateClaimStatus(claimId, newStatus);
        return ResponseEntity.ok().body(updatedClaim);
    }
}
