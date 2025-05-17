package com.example.internshipeval.service;

import com.example.internshipeval.model.Stagiaire;
import com.example.internshipeval.repositorie.StagiaireRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StagiaireService {
    private final StagiaireRepository stagiaireRepository;

    public StagiaireService(StagiaireRepository stagiaireRepository) {
        this.stagiaireRepository = stagiaireRepository;
    }

    public List<Stagiaire> findAll() {
        return stagiaireRepository.findAll();
    }

    public Stagiaire findById(Long id) {
        return stagiaireRepository.findById(id).orElse(null);
    }

    public Stagiaire save(Stagiaire stagiaire) {
        return stagiaireRepository.save(stagiaire);
    }

    public void delete(Long id) {
        stagiaireRepository.deleteById(id);
    }

    public Stagiaire update(Long id, Stagiaire updatedStagiaire) {
        Stagiaire existing = stagiaireRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Stagiaire not found"));

        // Mise à jour des champs
        existing.setNom(updatedStagiaire.getNom());
        existing.setPrenom(updatedStagiaire.getPrenom());
        existing.setEmail(updatedStagiaire.getEmail());
        existing.setInstitution(updatedStagiaire.getInstitution());

        return stagiaireRepository.save(existing);
    }
    public Stagiaire findOrCreate(String nom, String prenom, String email, String institution) {
        return stagiaireRepository.findByNomAndPrenom(nom, prenom)
                .orElseGet(() -> {
                    Stagiaire s = new Stagiaire();
                    s.setNom(nom);
                    s.setPrenom(prenom);
                    s.setEmail(email);
                    s.setInstitution(institution);
                    return stagiaireRepository.save(s);
                });
    }


}
