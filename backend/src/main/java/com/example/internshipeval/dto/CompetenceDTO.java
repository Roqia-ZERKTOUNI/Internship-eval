package com.example.internshipeval.dto;

import com.example.internshipeval.model.NiveauCompetence;

public class CompetenceDTO {
    private Long id;
    private String intitule;
    private NiveauCompetence niveau;
    private Long categorieId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public NiveauCompetence getNiveau() {
        return niveau;
    }

    public void setNiveau(NiveauCompetence niveau) {
        this.niveau = niveau;
    }

    public Long getCategorieId() {
        return categorieId;
    }

    public void setCategorieId(Long categorieId) {
        this.categorieId = categorieId;
    }
}


