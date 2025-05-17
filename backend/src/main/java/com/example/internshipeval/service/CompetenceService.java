package com.example.internshipeval.service;

import com.example.internshipeval.model.Competence;
import com.example.internshipeval.repositorie.CompetenceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompetenceService {
    private final CompetenceRepository competenceRepository;

    public CompetenceService(CompetenceRepository competenceRepository) {
        this.competenceRepository = competenceRepository;
    }

    public List<Competence> findAll() {
        return competenceRepository.findAll();
    }

    public Competence findById(Long id) {
        return competenceRepository.findById(id).orElse(null);
    }

    public Competence save(Competence competence) {
        return competenceRepository.save(competence);
    }

    public void delete(Long id) {
        competenceRepository.deleteById(id);
    }
}

