package com.enviro.assessment.grad001.ndamulelomulaudzi.service;

import com.enviro.assessment.grad001.ndamulelomulaudzi.model.RecyclingTip;
import com.enviro.assessment.grad001.ndamulelomulaudzi.repository.RecyclingTipRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecyclingTipService {
    private final RecyclingTipRepository repository;

    public RecyclingTipService(RecyclingTipRepository repository) {
        this.repository = repository;
    }

    public RecyclingTip saveTip(RecyclingTip tip) {
        return repository.save(tip);
    }

    public List<RecyclingTip> getAllTips() {
        return repository.findAll();
    }

    public RecyclingTip getTipById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Tip not found"));
    }

    public void deleteTip(Long id) {
        repository.deleteById(id);
    }
}
