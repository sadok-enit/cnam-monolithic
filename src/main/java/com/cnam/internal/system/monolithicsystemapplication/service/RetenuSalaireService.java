package com.cnam.internal.system.monolithicsystemapplication.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cnam.internal.system.monolithicsystemapplication.model.RetenuSalaire;
import com.cnam.internal.system.monolithicsystemapplication.repository.RetenuSalaireRepository;

@Service
public class RetenuSalaireService {

    @Autowired
    RetenuSalaireRepository retenuSalaireRepository;

    public ResponseEntity<byte[]> retrieveContentInCsv() {
        try {
            List<RetenuSalaire> retenuSalaires = retenuSalaireRepository.findAll();
            if (retenuSalaires.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            byte[] csvBytes = this.convertToCSV(retenuSalaires);

            return new ResponseEntity<>(csvBytes, this.setHttpHeadersForCsv(), HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

    }

    private HttpHeaders setHttpHeadersForCsv() {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType("text/csv"));
        String filename = "data.csv";

        headers.setContentDispositionFormData(filename, filename);
        headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
        return headers;
    }

    private byte[] convertToCSV(List<RetenuSalaire> data) {
        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
             CSVPrinter csvPrinter = new CSVPrinter(new OutputStreamWriter(outputStream), CSVFormat.DEFAULT)) {
            // map data to csv
            for (RetenuSalaire retenuSalaire : data) {
                csvPrinter.printRecord(
                        retenuSalaire.getCode(),
                        retenuSalaire.getMatricule(),
                        retenuSalaire.getNom(),
                        retenuSalaire.getPrenom(),
                        retenuSalaire.getDateSoin(),
                        retenuSalaire.getNumeroBordereau(),
                        retenuSalaire.getEtablissementsConventionnes(),
                        retenuSalaire.getBRecu(),
                        retenuSalaire.getMontant(),
                        retenuSalaire.getMotif()
                );
            }
            csvPrinter.flush();
            return outputStream.toByteArray();
        } catch (IOException e) {
            // Handle exception later
            e.printStackTrace();
            return new byte[0];
        }
    }

}
