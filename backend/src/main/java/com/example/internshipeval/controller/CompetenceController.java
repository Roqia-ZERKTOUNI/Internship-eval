package com.example.internshipeval.controller;

import com.example.internshipeval.dto.CompetenceDTO;
import com.example.internshipeval.model.Competence;
import com.example.internshipeval.service.CategorieService;
import com.example.internshipeval.service.CompetenceService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/competences")
public class CompetenceController {

    @Autowired
    private CompetenceService competenceService;

    @Autowired
    private CategorieService categorieService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public CompetenceDTO create(@RequestBody CompetenceDTO dto) {
        Competence entity = new Competence();
        entity.setIntitule(dto.getIntitule());
        entity.setNiveau(dto.getNiveau());
        entity.setCategorie(categorieService.findById(dto.getCategorieId()));

        return modelMapper.map(competenceService.save(entity), CompetenceDTO.class);
    }

    @GetMapping
    public List<CompetenceDTO> getAll() {
        return competenceService.findAll().stream()
                .map(comp -> {
                    CompetenceDTO dto = new CompetenceDTO();
                    dto.setId(comp.getId());
                    dto.setIntitule(comp.getIntitule());
                    dto.setNiveau(comp.getNiveau());
                    dto.setCategorieId(comp.getCategorie().getId());
                    return dto;
                }).collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    public CompetenceDTO update(@PathVariable Long id, @RequestBody CompetenceDTO dto) {
        Competence competence = competenceService.findById(id);
        competence.setIntitule(dto.getIntitule());
        competence.setNiveau(dto.getNiveau());
        competence.setCategorie(categorieService.findById(dto.getCategorieId()));
        return modelMapper.map(competenceService.save(competence), CompetenceDTO.class);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        competenceService.delete(id);
    }
}

