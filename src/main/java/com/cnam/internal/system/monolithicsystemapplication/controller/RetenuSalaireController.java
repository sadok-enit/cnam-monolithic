package com.cnam.internal.system.monolithicsystemapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cnam.internal.system.monolithicsystemapplication.service.RetenuSalaireService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class RetenuSalaireController {

    @Autowired
    private RetenuSalaireService retenuSalaireService;

    @GetMapping("/retenu-salaire-csv")
    public ResponseEntity<byte[]> getContentInCsv() {
        return retenuSalaireService.retrieveContentInCsv();
    }

}
