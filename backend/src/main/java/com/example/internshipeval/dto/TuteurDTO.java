package com.example.internshipeval.dto;

public class TuteurDTO {
    private Long id;
    private String nomTuteur;
    private String prenomTuteur;
    private String emailTuteur;
    private String entreprise;

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

    public String getEmailTuteur() {
        return emailTuteur;
    }

    public void setEmailTuteur(String emailTuteur) {
        this.emailTuteur = emailTuteur;
    }

    public String getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(String entreprise) {
        this.entreprise = entreprise;
    }



}
