package com.example.internshipeval.service;

import com.example.internshipeval.model.Appreciation;
import com.example.internshipeval.model.Categorie;
import com.example.internshipeval.repositorie.CategorieRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategorieService {
    private final CategorieRepository categorieRepository;

    public CategorieService(CategorieRepository categorieRepository) {
        this.categorieRepository = categorieRepository;
    }

    public List<Categorie> findAll() {
        return categorieRepository.findAll();
    }

    public Categorie findById(Long id) {
        return categorieRepository.findById(id).orElse(null);
    }

    public Categorie save(Categorie categorie) {
        return categorieRepository.save(categorie);
    }

    public void delete(Long id) {
        categorieRepository.deleteById(id);
    }

    public Categorie update(Long id, Categorie entity) {
        Categorie existing = categorieRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Catégorie introuvable avec ID : " + id));

        existing.setIntitule(entity.getIntitule());
        existing.setNote(entity.getNote());

        return categorieRepository.save(existing);
    }


}
