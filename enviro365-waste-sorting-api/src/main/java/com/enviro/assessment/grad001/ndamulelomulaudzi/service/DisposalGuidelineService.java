package com.enviro.assessment.grad001.ndamulelomulaudzi.service;

import com.enviro.assessment.grad001.ndamulelomulaudzi.model.DisposalGuideline;


import java.util.List;
import java.util.Optional;

public interface DisposalGuidelineService {
    List<DisposalGuideline> getAllGuidelines();
    Optional<DisposalGuideline> getGuidelineById(Long id);
    DisposalGuideline saveGuideline(DisposalGuideline Guideline);
    void deleteGuideline(Long id);
}