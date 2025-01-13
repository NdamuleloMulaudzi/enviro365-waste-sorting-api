package com.enviro.assessment.grad001.ndamulelomulaudzi.service;

import com.enviro.assessment.grad001.ndamulelomulaudzi.model.DisposalGuideline;
import com.enviro.assessment.grad001.ndamulelomulaudzi.repository.DisposalGuidelineRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DisposalGuidelineServiceImp implements DisposalGuidelineService {
    private final DisposalGuidelineRepository repository;

    // Injecting the repository into the service.
    public DisposalGuidelineServiceImp(DisposalGuidelineRepository repository) {
        this.repository = repository;
    }

    // Fetch all disposal guidelines from the database.
    public List<DisposalGuideline> getAllGuidelines() {
        return repository.findAll();
    }

    // Fetch a specific guideline by ID
    public Optional<DisposalGuideline> getGuidelineById(Long id) {
        return repository.findById(id);
    }

    // Save a guideline or update an existing one.
    public DisposalGuideline saveGuideline(DisposalGuideline guideline) {
        return repository.save(guideline);
    }

    // Delete a guideline by ID
    public void deleteGuideline(Long id) {
        repository.deleteById(id);
    }
}
