package com.example.internshipeval.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Stagiaire extends Personne {

    private String institution;



    public Stagiaire() {

    }

    public Stagiaire(String nom, String prenom, String email, String institution) {
        this.setNom(nom);
        this.setPrenom(prenom);
        this.setEmail(email);
        this.institution = institution;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    @OneToMany(mappedBy = "stagiaire")
    private List<Periode> periodes;
}
