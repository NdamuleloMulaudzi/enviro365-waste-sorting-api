package com.enviro.assessment.grad001.ndamulelomulaudzi.repository;

import com.enviro.assessment.grad001.ndamulelomulaudzi.model.DisposalGuideline;
import org.springframework.data.jpa.repository.JpaRepository;

// This interface handles database operations for DisposalGuideline.
public interface DisposalGuidelineRepository extends JpaRepository<DisposalGuideline, Long> {
    // JpaRepository gives me CRUD methods
}
