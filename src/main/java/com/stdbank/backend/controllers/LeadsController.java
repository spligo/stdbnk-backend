package com.stdbank.backend.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/leads")
public class LeadsController {

    @CrossOrigin
    @PostMapping
    public ResponseEntity<Boolean> createLead(@RequestBody Map<String, Object> lead) {

        return ResponseEntity.ok(true);

    }

}
