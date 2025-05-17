package com.example.internshipeval.service;

import com.example.internshipeval.model.Stage;
import com.example.internshipeval.repositorie.StageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StageService {
    private final StageRepository stageRepository;

    public StageService(StageRepository stageRepository) {
        this.stageRepository = stageRepository;
    }

    public List<Stage> findAll() {
        return stageRepository.findAll();
    }

    public Stage findById(Long id) {
        return stageRepository.findById(id).orElse(null);
    }

    public Stage save(Stage stage) {
        return stageRepository.save(stage);
    }

    public void delete(Long id) {
        stageRepository.deleteById(id);
    }
}

