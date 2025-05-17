package com.example.internshipeval.service;

import com.example.internshipeval.model.Appreciation;
import com.example.internshipeval.model.Evaluation;
import com.example.internshipeval.repositorie.EvaluationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EvaluationService {
    private final EvaluationRepository evaluationRepository;

    public EvaluationService(EvaluationRepository evaluationRepository) {
        this.evaluationRepository = evaluationRepository;
    }

    public List<Evaluation> findAll() {
        return evaluationRepository.findAll();
    }

    public Evaluation findById(Long id) {
        return evaluationRepository.findById(id).orElse(null);
    }

    public Evaluation save(Evaluation evaluation) {
        return evaluationRepository.save(evaluation);
    }

    public void delete(Long id) {
        evaluationRepository.deleteById(id);
    }public Evaluation update(Long id, Evaluation updatedEvaluation) {
        Evaluation existing = evaluationRepository.findById(id).orElse(null);
        if (existing == null) {
            return null;
        }

        existing.setImplication(updatedEvaluation.getImplication());
        existing.setOuverture(updatedEvaluation.getOuverture());
        existing.setQualiteProductions(updatedEvaluation.getQualiteProductions());
        existing.setObservations(updatedEvaluation.getObservations());
        existing.setAppreciation(updatedEvaluation.getAppreciation());

        return evaluationRepository.save(existing);
    }

}

