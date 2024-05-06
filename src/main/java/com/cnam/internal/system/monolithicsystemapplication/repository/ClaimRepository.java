package com.cnam.internal.system.monolithicsystemapplication.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cnam.internal.system.monolithicsystemapplication.model.Claim;

@Repository
public interface ClaimRepository extends JpaRepository<Claim, Long> {
    Optional<Claim> findClaimById(Long id);
}

