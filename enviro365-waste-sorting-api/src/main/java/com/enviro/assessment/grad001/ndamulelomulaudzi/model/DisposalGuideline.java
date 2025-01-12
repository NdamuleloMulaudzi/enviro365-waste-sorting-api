package com.enviro.assessment.grad001.ndamulelomulaudzi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
public class DisposalGuideline {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Waste type is mandatory")
    private String wasteType;

    @NotBlank(message = "Guideline is mandatory")
    private String guideline;

    //Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setWasteType(String wasteType) {
        this.wasteType = wasteType;
    }

    public void setGuideline(String guideline) {
        this.guideline = guideline;
    }


    //Getters
    public Long getId() {
        return id;
    }

    public String getWasteType() {
        return wasteType;
    }

    public String getGuideline() {
        return guideline;
    }



}
