package com.enviro.assessment.grad001.ndamulelomulaudzi.service;

import com.enviro.assessment.grad001.ndamulelomulaudzi.model.RecyclingTip;


import java.util.List;
import java.util.Optional;

public interface RecyclingTipService {
    List<RecyclingTip> getAllTips();
    Optional<RecyclingTip> getTipById(Long id);
    RecyclingTip saveTip(RecyclingTip tip);
    void deleteTip(Long id);
}