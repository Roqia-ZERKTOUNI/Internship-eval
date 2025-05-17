package com.example.internshipeval.dto;

import java.util.List;

public class AppreciationDTO {

    private Long id;
    private Long periodeId;
    private Long tuteurId;
    private List<Long> evaluationIds;
    private List<Long> categorieIds;

    public List<Long> getEvaluationIds() {
        return evaluationIds;
    }

    public List<Long> getCategorieIds() {
        return categorieIds;
    }

    public void setCategorieIds(List<Long> categorieIds) {
        this.categorieIds = categorieIds;
    }

    public void setEvaluationIds(List<Long> evaluationIds) {
        this.evaluationIds = evaluationIds;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public Long getPeriodeId() {
        return periodeId;
    }

    public Long getTuteurId() {
        return tuteurId;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setPeriodeId(Long periodeId) {
        this.periodeId = periodeId;
    }

    public void setTuteurId(Long tuteurId) {
        this.tuteurId = tuteurId;
    }

}
