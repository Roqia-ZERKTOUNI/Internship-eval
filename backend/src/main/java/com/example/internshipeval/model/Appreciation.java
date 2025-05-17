package com.example.internshipeval.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Appreciation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Periode periode;

    @ManyToOne
    private Tuteur tuteur;

    @OneToMany(mappedBy = "appreciation", cascade = CascadeType.ALL)
    private List<Evaluation> evaluations;
    @OneToMany(mappedBy = "appreciation", cascade = CascadeType.ALL)
    private List<Categorie> categories;

    public List<Evaluation> getEvaluations() {
        return evaluations;
    }
    public void setEvaluations(List<Evaluation> evaluations) {
        this.evaluations = evaluations;
    }



    // Getters
    public Long getId() {
        return id;
    }

    public Periode getPeriode() {
        return periode;
    }

    public Tuteur getTuteur() {
        return tuteur;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setPeriode(Periode periode) {
        this.periode = periode;
    }

    public void setTuteur(Tuteur tuteur) {
        this.tuteur = tuteur;
    }

    public List<Categorie> getCategories() {
        return categories;
    }

    public void setCategories(List<Categorie> categories) {
        this.categories = categories;
    }
}
