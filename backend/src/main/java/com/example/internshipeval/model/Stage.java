package com.example.internshipeval.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Stage {
    public String getEntreprise() {
        return entreprise;
    }

    public List<Periode> getPeriodes() {
        return periodes;
    }

    public void setPeriodes(List<Periode> periodes) {
        this.periodes = periodes;
    }

    public void setEntreprise(String entreprise) {
        this.entreprise = entreprise;
    }

    public Long getId() {
        return id;
    }

    public String getObjectif() {
        return objectif;
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

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private String objectif;
    private String entreprise;

    @OneToMany(mappedBy = "stage")
    private List<Periode> periodes;

    public Stagiaire getStagiaire() {
        return stagiaire;
    }

    public void setStagiaire(Stagiaire stagiaire) {
        this.stagiaire = stagiaire;
    }

    @ManyToOne
    @JoinColumn(name = "stagiaire_id", referencedColumnName = "id")  // Association avec Stagiaire
    private Stagiaire stagiaire; // Ajout de l'attribut stagiaire
}

