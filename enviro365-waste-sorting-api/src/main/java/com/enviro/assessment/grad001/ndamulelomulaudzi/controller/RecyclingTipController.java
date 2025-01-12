package com.enviro.assessment.grad001.ndamulelomulaudzi.controller;

import com.enviro.assessment.grad001.ndamulelomulaudzi.model.RecyclingTip;
import com.enviro.assessment.grad001.ndamulelomulaudzi.service.RecyclingTipService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/recycling-tips")
public class RecyclingTipController {
    private final RecyclingTipService service;

    public RecyclingTipController(RecyclingTipService service) {
        this.service = service;
    }

    // Endpoint to retrieve all Recycling Tips from the database.
    @GetMapping
    public List<RecyclingTip> getAllTips() {
        return service.getAllTips();
    }

    // Endpoint to retrieve a specific tip by its ID.
    @GetMapping("/{id}")
    public ResponseEntity<Object> getTipById(@PathVariable Long id) {
        Optional<RecyclingTip> tip = service.getTipById(id);
        if (tip.isEmpty()) {
            // Return a custom message with 404 Not Found
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Recycling tip with ID " + id + " not found");
        }
        return ResponseEntity.ok(tip.get());
    }


    // Endpoint to create a new tip.
    @PostMapping
    public ResponseEntity<Object> createTip(@Valid @RequestBody RecyclingTip tip) {
        try {
            RecyclingTip savedTip = service.saveTip(tip);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedTip);
        } catch (Exception e) {
            // Handles error during guideline creation, returns 500 Internal Server Error
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error occurred while saving the recycling tip: " + e.getMessage());
        }
    }


    // Endpoint to update a specific existing tip by its ID
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateTip(@PathVariable Long id, @Valid @RequestBody RecyclingTip tip) {
        Optional<RecyclingTip> existingTip = service.getTipById(id);
        if (existingTip.isEmpty()) {
            // Return a custom message with 404 Not Found if the guideline doesn't exist
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Recycling tip with ID " + id + " not found");
        }

        tip.setId(id);
        RecyclingTip updatedTip = service.saveTip(tip);
        return ResponseEntity.ok(updatedTip);
    }

    // Endpoint to delete a tip by its ID.
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteTip(@PathVariable Long id) {
        Optional<RecyclingTip> existingTip = service.getTipById(id);
        if (existingTip.isEmpty()) {
            // Return a custom message with 404 Not Found if the guideline doesn't exist
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Recycling tip with ID " + id + " not found");
        }

        service.deleteTip(id);
        return ResponseEntity.noContent().build();
    }

}
