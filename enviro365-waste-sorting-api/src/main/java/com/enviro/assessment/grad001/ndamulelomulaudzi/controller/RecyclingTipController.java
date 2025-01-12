package com.enviro.assessment.grad001.ndamulelomulaudzi.controller;

import com.enviro.assessment.grad001.ndamulelomulaudzi.model.RecyclingTip;
import com.enviro.assessment.grad001.ndamulelomulaudzi.service.RecyclingTipService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recycling-tips")
public class RecyclingTipController {
    private final RecyclingTipService service;

    public RecyclingTipController(RecyclingTipService service) {
        this.service = service;
    }

    @GetMapping
    public List<RecyclingTip> getAllTips() {
        return service.getAllTips();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecyclingTip> getTipById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getTipById(id));
    }

    @PostMapping
    public ResponseEntity<RecyclingTip> createTip(@Valid @RequestBody RecyclingTip tip) {
        return ResponseEntity.ok(service.saveTip(tip));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RecyclingTip> updateTip(@PathVariable Long id, @Valid @RequestBody RecyclingTip tip) {
        tip.setId(id);
        return ResponseEntity.ok(service.saveTip(tip));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTip(@PathVariable Long id) {
        service.deleteTip(id);
        return ResponseEntity.noContent().build();
    }
}
