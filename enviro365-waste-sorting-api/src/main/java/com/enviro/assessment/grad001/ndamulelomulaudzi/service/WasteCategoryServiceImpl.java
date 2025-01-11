package com.enviro.assessment.grad001.ndamulelomulaudzi.service;

import com.enviro.assessment.grad001.ndamulelomulaudzi.model.WasteCategory;
import com.enviro.assessment.grad001.ndamulelomulaudzi.repository.WasteCategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WasteCategoryServiceImpl implements WasteCategoryService {
    private final WasteCategoryRepository repository;

    public WasteCategoryServiceImpl(WasteCategoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<WasteCategory> getAllCategories() {
        return repository.findAll();
    }

    @Override
    public WasteCategory getCategoryById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));
    }

    @Override
    public WasteCategory saveCategory(WasteCategory category) {
        return repository.save(category);
    }

    @Override
    public void deleteCategory(Long id) {
        repository.deleteById(id);
    }
}
