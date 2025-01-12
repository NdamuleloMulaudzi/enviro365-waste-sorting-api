package com.enviro.assessment.grad001.ndamulelomulaudzi.controller;

import com.enviro.assessment.grad001.ndamulelomulaudzi.model.DisposalGuideline;
import com.enviro.assessment.grad001.ndamulelomulaudzi.service.DisposalGuidelineService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/disposal-guidelines")
public class DisposalGuidelineController {
    private final DisposalGuidelineService service;

    public DisposalGuidelineController(DisposalGuidelineService service) {
        this.service = service;
    }

    @GetMapping
    public List<DisposalGuideline> getAllGuidelines() {
        return service.getAllGuidelines();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DisposalGuideline> getGuidelineById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getGuidelineById(id));
    }

    @PostMapping
    public ResponseEntity<DisposalGuideline> createGuideline(@Valid @RequestBody DisposalGuideline guideline) {
        return ResponseEntity.ok(service.saveGuideline(guideline));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DisposalGuideline> updateGuideline(
            @PathVariable Long id, @Valid @RequestBody DisposalGuideline guideline) {
        guideline.setId(id);
        return ResponseEntity.ok(service.saveGuideline(guideline));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGuideline(@PathVariable Long id) {
        service.deleteGuideline(id);
        return ResponseEntity.noContent().build();
    }
}
