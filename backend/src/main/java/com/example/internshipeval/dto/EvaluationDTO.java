package com.example.internshipeval.dto;
public class EvaluationDTO {
    private Long id;
    private String implication;
    private String ouverture;
    private String qualiteProductions;
    private String observations;
    private Long appreciationId;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getImplication() {
        return implication;
    }

    public void setImplication(String implication) {
        this.implication = implication;
    }

    public String getOuverture() {
        return ouverture;
    }

    public void setOuverture(String ouverture) {
        this.ouverture = ouverture;
    }

    public String getQualiteProductions() {
        return qualiteProductions;
    }

    public void setQualiteProductions(String qualiteProductions) {
        this.qualiteProductions = qualiteProductions;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public Long getAppreciationId() {
        return appreciationId;
    }

    public void setAppreciationId(Long appreciationId) {
        this.appreciationId = appreciationId;
    }


}


