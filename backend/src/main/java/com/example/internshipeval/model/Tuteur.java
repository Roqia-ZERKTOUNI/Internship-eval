package com.example.internshipeval.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Tuteur extends Personne {
    public Tuteur(String nom, String prenom, String email, String entreprise) {
        this.setNom(nom);
        this.setPrenom(prenom);
        this.setEmail(email);
        this.entreprise = entreprise;
    }

    public Tuteur() {

    }

    public String getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(String entreprise) {
        this.entreprise = entreprise;
    }

    private String entreprise;

    @OneToMany(mappedBy = "tuteur")
    private List<Appreciation> appreciations;

    public List<Appreciation> getAppreciations() {
        return appreciations;
    }

    public void setAppreciations(List<Appreciation> appreciations) {
        this.appreciations = appreciations;
    }
}

