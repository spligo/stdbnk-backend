package com.stdbank.backend.controllers;

import com.stdbank.backend.services.CsvImportService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/leads")
public class LeadsController {

    private static final Logger logger = LoggerFactory.getLogger(LeadsController.class);

    @CrossOrigin
    @PostMapping
    public ResponseEntity<Boolean> createLead(@RequestBody Map<String, Object> lead) {

        logger.info("Saving lead {}", lead);
        return ResponseEntity.ok(true);

    }

}
