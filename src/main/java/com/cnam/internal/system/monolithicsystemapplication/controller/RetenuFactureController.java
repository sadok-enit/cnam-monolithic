package com.cnam.internal.system.monolithicsystemapplication.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cnam.internal.system.monolithicsystemapplication.service.RetenuFactureService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class RetenuFactureController {

    @Autowired
    private RetenuFactureService retenuFactureService;

    @GetMapping("/retenu-facture-csv")
    public ResponseEntity<byte[]> getContentInCsv() {
        return retenuFactureService.retrieveContentInCsv();
    }

}
