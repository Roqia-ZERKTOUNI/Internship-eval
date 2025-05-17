package com.example.internshipeval.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.util.List;

public class EvaluationGlobaleDTO {

    // Étape 1
    public String nomStagiaire;
    public String prenomStagiaire;
    private String emailStagiaire;
    public String nomTuteur;
    public String prenomTuteur;
    private String emailTuteur;
    private String entreprise;
    @JsonFormat(pattern = "yyyy-MM-dd")
    public LocalDate dateDebut;
    @JsonFormat(pattern = "yyyy-MM-dd")
    public LocalDate dateFin;
    private String description;
    private String objectif;
private String institution;

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    // Étape 2 : évaluation globale
    public String implication;
    public String ouverture;
    public String qualiteProductions;
    public String observations;

    // Étape 3 à 5 : catégories et compétences
    public List<CategorieCompetenceDTO> categories;

    public String getNomStagiaire() {
        return nomStagiaire;
    }

    public void setNomStagiaire(String nomStagiaire) {
        this.nomStagiaire = nomStagiaire;
    }

    public String getPrenomStagiaire() {
        return prenomStagiaire;
    }

    public void setPrenomStagiaire(String prenomStagiaire) {
        this.prenomStagiaire = prenomStagiaire;
    }

    public String getNomTuteur() {
        return nomTuteur;
    }

    public void setNomTuteur(String nomTuteur) {
        this.nomTuteur = nomTuteur;
    }

    public String getPrenomTuteur() {
        return prenomTuteur;
    }

    public void setPrenomTuteur(String prenomTuteur) {
        this.prenomTuteur = prenomTuteur;
    }

    public String getEmailStagiaire() {
        return emailStagiaire;
    }

    public void setEmailStagiaire(String emailStagiaire) {
        this.emailStagiaire = emailStagiaire;
    }

    public String getEmailTuteur() {
        return emailTuteur;
    }

    public void setEmailTuteur(String emailTuteur) {
        this.emailTuteur = emailTuteur;
    }

    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

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

    public List<CategorieCompetenceDTO> getCategories() {
        return categories;
    }

    public void setCategories(List<CategorieCompetenceDTO> categories) {
        this.categories = categories;
    }

    public String getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(String entreprise) {
        this.entreprise = entreprise;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getObjectif() {
        return objectif;
    }

    public void setObjectif(String objectif) {
        this.objectif = objectif;
    }
}
