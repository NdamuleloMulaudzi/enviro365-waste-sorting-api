package com.enviro.assessment.grad001.ndamulelomulaudzi.service;

import com.enviro.assessment.grad001.ndamulelomulaudzi.model.DisposalGuideline;
import com.enviro.assessment.grad001.ndamulelomulaudzi.repository.DisposalGuidelineRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisposalGuidelineService {
    private final DisposalGuidelineRepository repository;

    public DisposalGuidelineService(DisposalGuidelineRepository repository) {
        this.repository = repository;
    }

    public List<DisposalGuideline> getAllGuidelines() {
        return repository.findAll();
    }

    public DisposalGuideline getGuidelineById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Guideline not found"));
    }

    public DisposalGuideline saveGuideline(DisposalGuideline guideline) {
        return repository.save(guideline);
    }

    public void deleteGuideline(Long id) {
        repository.deleteById(id);
    }
}
