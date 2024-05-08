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

import com.cnam.internal.system.monolithicsystemapplication.model.RetenuFacture;
import com.cnam.internal.system.monolithicsystemapplication.repository.RetenuFactureRepository;

@Service
public class RetenuFactureService {
    @Autowired
    RetenuFactureRepository retenuFactureRepository;

    public ResponseEntity<byte[]> retrieveContentInCsv() {
        try {
            List<RetenuFacture> retenuFactures = retenuFactureRepository.findAll();
            if (retenuFactures.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            byte[] csvBytes = this.convertToCSV(retenuFactures);

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

    private byte[] convertToCSV(List<RetenuFacture> data) {
        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
             CSVPrinter csvPrinter = new CSVPrinter(new OutputStreamWriter(outputStream), CSVFormat.DEFAULT)) {
            // map data to csv
            for (RetenuFacture retenuFacture : data) {
                csvPrinter.printRecord(
                        retenuFacture.getCode(),
                        retenuFacture.getMatricule(),
                        retenuFacture.getNom(),
                        retenuFacture.getPrenom(),
                        retenuFacture.getDateSoin(),
                        retenuFacture.getNumeroBordereau(),
                        retenuFacture.getEtablissementsConventionnes(),
                        retenuFacture.getBRecu(),
                        retenuFacture.getMontant(),
                        retenuFacture.getMotif()
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
