package com.enviro.assessment.grad001.ndamulelomulaudzi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
public class WasteCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotBlank(message = "Description is mandatory")
    private String description;

    // Method to trim spaces before saving or updating
    @PrePersist
    @PreUpdate
    private void trimFields() {
        if (name != null) {
            name = name.trim();
        }
        if (description != null) {
            description = description.trim();
        }
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

   //getters
   public String getName() {
       return name;
   }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }


}
