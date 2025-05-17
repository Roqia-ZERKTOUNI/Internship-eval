package com.example.internshipeval.service;

import com.example.internshipeval.model.Appreciation;
import com.example.internshipeval.repositorie.AppreciationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppreciationService {
    private final AppreciationRepository appreciationRepository;

    public AppreciationService(AppreciationRepository appreciationRepository) {
        this.appreciationRepository = appreciationRepository;
    }

    public List<Appreciation> findAll() {
        return appreciationRepository.findAll();
    }

    public Appreciation findById(Long id) {
        return appreciationRepository.findById(id).orElse(null);
    }

    public Appreciation save(Appreciation appreciation) {
        return appreciationRepository.save(appreciation);
    }

    public void delete(Long id) {
        appreciationRepository.deleteById(id);
    }
}

