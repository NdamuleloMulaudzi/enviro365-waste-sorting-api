package com.enviro.assessment.grad001.ndamulelomulaudzi.service;

import com.enviro.assessment.grad001.ndamulelomulaudzi.model.RecyclingTip;
import com.enviro.assessment.grad001.ndamulelomulaudzi.repository.RecyclingTipRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecyclingTipServiceImp implements RecyclingTipService {

    private final RecyclingTipRepository repository;

    // Injecting the repository into the service.

    public RecyclingTipServiceImp(RecyclingTipRepository repository) {
        this.repository = repository;
    }

    // Fetch all recycling tips from the database.
    public RecyclingTip saveTip(RecyclingTip tip) {
        return repository.save(tip);
    }

    // Fetch a specific tip by ID
    public List<RecyclingTip> getAllTips() {
        return repository.findAll();
    }

    // Save a tip or update an existing one.
    public Optional<RecyclingTip> getTipById(Long id) {
        return repository.findById(id);
    }

    // Delete a tip by ID
    public void deleteTip(Long id) {
        repository.deleteById(id);
    }
}
