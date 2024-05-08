package com.cnam.internal.system.monolithicsystemapplication.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cnam.internal.system.monolithicsystemapplication.exception.ResourceNotFoundException;
import com.cnam.internal.system.monolithicsystemapplication.model.Claim;
import com.cnam.internal.system.monolithicsystemapplication.model.ClaimDto;
import com.cnam.internal.system.monolithicsystemapplication.model.ClaimStatus;
import com.cnam.internal.system.monolithicsystemapplication.repository.ClaimRepository;

@Service
public class ClaimService {

    @Autowired
    ClaimRepository claimRepository;

    public ResponseEntity<List<Claim>> retrieveAllClaims() {
        List<Claim> claims = claimRepository.findAll();
        return claims.isEmpty() ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(claims, HttpStatus.OK);
    }

    public ResponseEntity<Claim> retrieveClaimById(Long id) {
        Optional<Claim> claim = claimRepository.findClaimById(id);
        return claim.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NO_CONTENT));
    }

    public ResponseEntity<ClaimStatus> retrieveClaimStatusById(Long id) {
        Optional<Claim> claim = claimRepository.findClaimById(id);
        return claim.map(value -> new ResponseEntity<>(value.getStatus(), HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NO_CONTENT));
    }

    public Claim addClaim(ClaimDto claimDto) {

        return claimRepository.save(
                Claim.builder()
                        .numeroReclamation(claimDto.getNumeroReclamation())
                        .libelle(claimDto.getLibelle())
                        .mntEngage(claimDto.getMntEngage())
                        .mntReclame(claimDto.getMntReclame())
                        .motif(claimDto.getMotif())
                        .date(claimDto.getDate())
                        .observation(claimDto.getObservation())
                        .bulletinCode(claimDto.getBulletinCode())
                        .numBordereauReclamation(claimDto.getNumBordereauReclamation())
                        .status(claimDto.getStatus())
                        .build()
        );
    }

    public void deleteClaimById(Long claimId) {
        claimRepository.deleteById(claimId);
    }

    public Claim updateClaimStatus(Long claimId, ClaimStatus newStatus) {
        Claim claim = claimRepository.findById(claimId)
                .orElseThrow(() -> new ResourceNotFoundException("Claim not found with id: " + claimId));

        claim.setStatus(newStatus);
        return claimRepository.save(claim);
    }

}
