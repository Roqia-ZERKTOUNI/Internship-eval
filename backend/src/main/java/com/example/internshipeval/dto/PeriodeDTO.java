package com.example.internshipeval.dto;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

public class PeriodeDTO {
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private LocalDate dateDebut;
    private LocalDate dateFin;
    private Long stageId;
    private Long stagiaireId;
    private List<Long> tuteurIds;

    public LocalDate getDateDebut() {
    return dateDebut;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public Long getStageId() {
        return stageId;
    }

    public Long getStagiaireId() {
        return stagiaireId;
    }

    public List<Long> getTuteurIds() {
        return tuteurIds;
    }
    public void setTuteurIds(List<Long> tuteurIds) {
        this.tuteurIds = tuteurIds;
    }

    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    public void setStageId(Long stageId) {
        this.stageId = stageId;
    }
    public void setStagiaireId(Long stagiaireId) {
        this.stagiaireId = stagiaireId;
    }
}

