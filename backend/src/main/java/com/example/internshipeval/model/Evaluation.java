package com.example.internshipeval.model;

import jakarta.persistence.*;

@Entity
public class Evaluation {

    @Enumerated(EnumType.STRING)
    private Implication implication;

    @Enumerated(EnumType.STRING)
    private Ouverture ouverture;

    @Enumerated(EnumType.STRING)
    private QualiteProduction qualiteProductions;
    @ManyToOne(optional = true)
    private Appreciation appreciation;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String observations;
    public Appreciation getAppreciation() {
        return appreciation;
    }

    public void setAppreciation(Appreciation appreciation) {
        this.appreciation = appreciation;
    }

    public Implication getImplication() {
        return implication;
    }


    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public QualiteProduction getQualiteProductions() {
        return qualiteProductions;
    }

    public void setQualiteProductions(QualiteProduction qualiteProductions) {
        this.qualiteProductions = qualiteProductions;
    }

    public Ouverture getOuverture() {
        return ouverture;
    }

    public void setOuverture(Ouverture ouverture) {
        this.ouverture = ouverture;
    }

    public void setImplication(Implication implication) {
        this.implication = implication;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

}
