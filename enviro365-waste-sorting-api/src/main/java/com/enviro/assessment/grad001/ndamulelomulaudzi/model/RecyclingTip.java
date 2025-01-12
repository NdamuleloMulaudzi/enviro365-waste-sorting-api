package com.enviro.assessment.grad001.ndamulelomulaudzi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
public class RecyclingTip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Title is mandatory")
    private String title;

    @NotBlank(message = "Tip content is mandatory")
    private String content;

    // Method to trim spaces before saving or updating
    @PrePersist
    @PreUpdate
    private void trimFields() {
        if (title != null) {
            title = title.trim();
        }
        if (content != null) {
            content = content.trim();
        }
    }


    //Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }


    // Getters
    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

}
