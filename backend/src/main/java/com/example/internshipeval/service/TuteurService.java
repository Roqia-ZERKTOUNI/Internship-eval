package com.example.internshipeval.service;

import com.example.internshipeval.model.Tuteur;
import com.example.internshipeval.repositorie.TuteurRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TuteurService {
    private final TuteurRepository tuteurRepository;

    public TuteurService(TuteurRepository tuteurRepository) {
        this.tuteurRepository = tuteurRepository;
    }

    public List<Tuteur> findAll() {
        return tuteurRepository.findAll();
    }

    public Tuteur findById(Long id) {
        return tuteurRepository.findById(id).orElse(null);
    }
    public Tuteur findOrCreate(String nom, String prenom, String email, String entreprise) {
        List<Tuteur> existing = tuteurRepository.findByNomAndPrenom(nom, prenom);
        if (!existing.isEmpty()) return existing.get(0);
        Tuteur tuteur = new Tuteur();
        tuteur.setNom(nom);
        tuteur.setPrenom(prenom);
        tuteur.setEmail(email);
        tuteur.setEntreprise(entreprise);
        return tuteurRepository.save(tuteur);
    }



    public Tuteur save(Tuteur tuteur) {
        return tuteurRepository.save(tuteur);
    }

    public void delete(Long id) {
        tuteurRepository.deleteById(id);
    }
}

