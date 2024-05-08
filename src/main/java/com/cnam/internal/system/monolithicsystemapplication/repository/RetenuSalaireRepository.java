package com.cnam.internal.system.monolithicsystemapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cnam.internal.system.monolithicsystemapplication.model.RetenuSalaire;

@Repository
public interface RetenuSalaireRepository extends JpaRepository<RetenuSalaire, Long> {

}

