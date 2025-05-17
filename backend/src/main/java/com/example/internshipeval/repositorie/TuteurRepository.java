package com.example.internshipeval.repositorie;

import com.example.internshipeval.model.Tuteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TuteurRepository extends JpaRepository<Tuteur, Long> {
    List<Tuteur> findByNomAndPrenom(String nom, String prenom);

}

