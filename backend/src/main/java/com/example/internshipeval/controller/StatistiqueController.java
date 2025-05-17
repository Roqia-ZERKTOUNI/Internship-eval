package com.example.internshipeval.controller;

import com.example.internshipeval.repositorie.EvaluationRepository;
import com.example.internshipeval.repositorie.StagiaireRepository;
import com.example.internshipeval.repositorie.TuteurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// StatistiqueController.java
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/statistiques")
public class StatistiqueController {
    @Autowired private StagiaireRepository stagiaireRepo;
    @Autowired
    private TuteurRepository tuteurRepo;
    @Autowired private EvaluationRepository evaluationRepo;

    @GetMapping("/nombre-stagiaires")
    public long getNombreStagiaires() {
        return stagiaireRepo.count();
    }

    @GetMapping("/nombre-tuteurs")
    public long getNombreTuteurs() {
        return tuteurRepo.count();
    }

    @GetMapping("/nombre-evaluations")
    public long getNombreEvaluations() {
        return evaluationRepo.count();
    }
}
