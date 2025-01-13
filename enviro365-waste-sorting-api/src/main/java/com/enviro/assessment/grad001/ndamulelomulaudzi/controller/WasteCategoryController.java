package com.enviro.assessment.grad001.ndamulelomulaudzi.controller;

import com.enviro.assessment.grad001.ndamulelomulaudzi.model.WasteCategory;
import com.enviro.assessment.grad001.ndamulelomulaudzi.service.WasteCategoryServiceimp;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/waste-categories")
public class WasteCategoryController {
    private final WasteCategoryServiceimp service;

    public WasteCategoryController(WasteCategoryServiceimp service) {
        this.service = service;
    }

    // Endpoint to retrieve all waste categories from the database.
    @GetMapping
    public ResponseEntity<Object> getAllCategories() {
        try {
            List<WasteCategory> categories = service.getAllCategories();
            if (categories.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT)
                        .body("No waste categories found");
            }
            return ResponseEntity.ok(categories);
        } catch (Exception e) {
            // Handle unexpected errors and return 500 Internal Server Error
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred while retrieving waste categories: " + e.getMessage());
        }
    }



    // Endpoint to retrieve a specific category by its ID.
    @GetMapping("/{id}")
    public ResponseEntity<Object> getCategoryById(@PathVariable Long id) {
        try {
            Optional<WasteCategory> category = service.getCategoryById(id);
            if (category.isEmpty()) {
                // Return a custom message with 404 Not Found
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Waste category with ID " + id + " not found");
            }
            return ResponseEntity.ok(category.get());
        } catch (Exception e) {
            // Handle unexpected errors and return 500 Internal Server Error
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred while retrieving the waste category: " + e.getMessage());
        }
    }



    // Endpoint to create a new category.
    @PostMapping
    public ResponseEntity<Object> createCategory(@Valid @RequestBody WasteCategory category) {
        try {
            WasteCategory savedCategory = service.saveCategory(category);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedCategory);
        } catch (Exception e) {
            // Handles error during category creation, returns 500 Internal Server Error
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error occurred while creating the waste category: " + e.getMessage());
        }
    }



    // Endpoint to update a specific existing category by its ID
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateCategory(@PathVariable Long id, @Valid @RequestBody WasteCategory category) {
        try {
            Optional<WasteCategory> existingCategory = service.getCategoryById(id);
            if (existingCategory.isEmpty()) {
                // Return a custom message with 404 Not Found if the category doesn't exist
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Waste category with ID " + id + " not found");
            }

            category.setId(id);
            WasteCategory updatedCategory = service.saveCategory(category);
            return ResponseEntity.ok(updatedCategory);
        } catch (Exception e) {
            // Handle unexpected errors and return 500 Internal Server Error
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred while updating the waste category: " + e.getMessage());
        }
    }



    // Endpoint to delete a category by its ID.
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteCategory(@PathVariable Long id) {
        try {
            Optional<WasteCategory> existingCategory = service.getCategoryById(id);
            if (existingCategory.isEmpty()) {
                // Return a custom message with 404 Not Found if the category doesn't exist
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Waste category with ID " + id + " not found");
            }

            service.deleteCategory(id);
            return ResponseEntity.status(HttpStatus.OK).body("Waste category with ID " + id + " deleted successfully");
        } catch (Exception e) {
            // Handle unexpected errors and return 500 Internal Server Error
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred while deleting the waste category: " + e.getMessage());
        }
    }


}
