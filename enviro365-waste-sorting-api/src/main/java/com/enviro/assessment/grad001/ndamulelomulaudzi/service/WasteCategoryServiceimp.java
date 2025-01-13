package com.enviro.assessment.grad001.ndamulelomulaudzi.service;

import com.enviro.assessment.grad001.ndamulelomulaudzi.model.WasteCategory;
import com.enviro.assessment.grad001.ndamulelomulaudzi.repository.WasteCategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WasteCategoryServiceimp implements WasteCategoryService{
    private final WasteCategoryRepository repository;

    public WasteCategoryServiceimp(WasteCategoryRepository repository) {
        this.repository = repository;
    }

    // Fetch all waste category from the database.
    public List<WasteCategory> getAllCategories() {
        return repository.findAll();
    }

    // Fetch a specific category by ID
    public Optional<WasteCategory> getCategoryById(Long id) {
        return repository.findById(id);
    }

    // Save a category or update an existing one.
    public WasteCategory saveCategory(WasteCategory category) {
        return repository.save(category);
    }

    // Delete a category by ID
    public void deleteCategory(Long id) {
        repository.deleteById(id);
    }
}
