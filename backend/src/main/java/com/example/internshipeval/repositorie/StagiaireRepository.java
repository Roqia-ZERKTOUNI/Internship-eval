package com.example.internshipeval.repositorie;

import com.example.internshipeval.model.Stagiaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StagiaireRepository extends JpaRepository<Stagiaire, Long> {
    Optional<Stagiaire> findByNomAndPrenom(String nom, String prenom);

}

