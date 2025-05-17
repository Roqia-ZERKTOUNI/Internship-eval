package com.example.internshipeval.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Periode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public List<Tuteur> getTuteurs() {
        return tuteurs;
    }

    public void setTuteurs(List<Tuteur> tuteurs) {
        this.tuteurs = tuteurs;
    }

    public Stagiaire getStagiaire() {
        return stagiaire;
    }

    public void setStagiaire(Stagiaire stagiaire) {
        this.stagiaire = stagiaire;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }

    private LocalDate dateDebut;
    private LocalDate dateFin;

    @ManyToOne
    private Stage stage;

    @ManyToOne
    private Stagiaire stagiaire;

    @ManyToMany
    @JoinTable(
            name = "periode_tuteur",
            joinColumns = @JoinColumn(name = "periode_id"),
            inverseJoinColumns = @JoinColumn(name = "tuteur_id")
    )
    private List<Tuteur> tuteurs;

    @OneToMany(mappedBy = "periode")
    private List<Appreciation> appreciations;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
