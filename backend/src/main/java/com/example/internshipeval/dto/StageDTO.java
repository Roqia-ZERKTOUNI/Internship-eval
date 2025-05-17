package com.example.internshipeval.dto;

import com.example.internshipeval.model.Stagiaire;

public class StageDTO {
    private Long id;
    private String description;
    private String objectif;
    private Stagiaire stagiaire;

    public Stagiaire getStagiaire() {
        return stagiaire;
    }

    public void setStagiaire(Stagiaire stagiaire) {
        this.stagiaire = stagiaire;
    }

    public String getObjectif() {
        return objectif;
    }

    public Long getId() {
        return id;
    }

    public String getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(String entreprise) {
        this.entreprise = entreprise;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setObjectif(String objectif) {
        this.objectif = objectif;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private String entreprise;


}
