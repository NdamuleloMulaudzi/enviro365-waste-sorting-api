package com.enviro.assessment.grad001.ndamulelomulaudzi.service;

import com.enviro.assessment.grad001.ndamulelomulaudzi.model.WasteCategory;

import java.util.List;
import java.util.Optional;

public interface WasteCategoryService {
    List<WasteCategory> getAllCategories();
    Optional<WasteCategory> getCategoryById(Long id);
    WasteCategory saveCategory(WasteCategory category);
    void deleteCategory(Long id);
}