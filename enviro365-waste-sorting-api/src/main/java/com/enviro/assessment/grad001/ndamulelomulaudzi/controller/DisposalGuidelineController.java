package com.enviro.assessment.grad001.ndamulelomulaudzi.controller;

import com.enviro.assessment.grad001.ndamulelomulaudzi.model.DisposalGuideline;
import com.enviro.assessment.grad001.ndamulelomulaudzi.service.DisposalGuidelineServiceImp;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/disposal-guidelines")
public class DisposalGuidelineController {
    private final DisposalGuidelineServiceImp service;

    public DisposalGuidelineController(DisposalGuidelineServiceImp service) {
        this.service = service;
    }

    // Endpoint to retrieve all disposal guidelines from the database.
    @GetMapping
    public ResponseEntity<Object> getAllGuidelines() {
        try {
            List<DisposalGuideline> guidelines = service.getAllGuidelines();
            if (guidelines.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT)
                        .body("No disposal guidelines found");
            }
            return ResponseEntity.ok(guidelines);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred while retrieving the disposal guidelines: " + e.getMessage());
        }
    }


    // Endpoint to retrieve a specific guideline by its ID.
    @GetMapping("/{id}")
    public ResponseEntity<Object> getGuidelineById(@PathVariable Long id) {
        try {
            Optional<DisposalGuideline> guideline = service.getGuidelineById(id);
            if (guideline.isEmpty()) {
                // Return a custom message with 404 Not Found
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Guideline with ID " + id + " not found");
            }
            return ResponseEntity.ok(guideline);
        } catch (Exception e) {
            // Return 500 Internal Server Error if something goes wrong
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred while retrieving the guideline: " + e.getMessage());
        }
    }




    // Endpoint to create a new guideline with.
    @PostMapping
    public ResponseEntity<Object> createGuideline(@Valid @RequestBody DisposalGuideline guideline) {
        try {
            DisposalGuideline savedGuideline = service.saveGuideline(guideline);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedGuideline);
        } catch (Exception e) {
            // Handles error during guideline creation, returns 500 Internal Server Error
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error creating guideline: " + e.getMessage());
        }
    }

    // Endpoint to update a specific existing guideline by its ID
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateGuideline(
            @PathVariable Long id, @Valid @RequestBody DisposalGuideline guideline) {
        try {
            Optional<DisposalGuideline> existingGuideline = service.getGuidelineById(id);
            if (existingGuideline.isEmpty()) {
                // Return a custom message with 404 Not Found if the guideline doesn't exist
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Guideline with ID " + id + " not found");
            }

            guideline.setId(id);
            DisposalGuideline updatedGuideline = service.saveGuideline(guideline);
            return ResponseEntity.ok(updatedGuideline);
        } catch (Exception e) {
            // Handle unexpected errors and return 500 Internal Server Error
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred while updating the guideline: " + e.getMessage());
        }
    }


    // Endpoint to delete a guideline by its ID.
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteGuideline(@PathVariable Long id) {
        try {
            Optional<DisposalGuideline> existingGuideline = service.getGuidelineById(id);
            if (existingGuideline.isEmpty()) {
                // Return a custom message with 404 Not Found if the guideline doesn't exist
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Guideline with ID " + id + " not found");
            }

            service.deleteGuideline(id);
            return ResponseEntity.status(HttpStatus.OK).body("Guideline with ID " + id + " deleted successfully");
        } catch (Exception e) {
            // Handle unexpected errors and return 500 Internal Server Error
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred while deleting the guideline: " + e.getMessage());
        }
    }

}
