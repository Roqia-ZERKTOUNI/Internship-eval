package com.example.internshipeval.controller;

import com.example.internshipeval.dto.AppreciationDTO;
import com.example.internshipeval.model.Appreciation;
import com.example.internshipeval.model.Categorie;
import com.example.internshipeval.model.Competence;
import com.example.internshipeval.model.Evaluation;
import com.example.internshipeval.service.*;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
@RestController
@RequestMapping("/api/appreciations")
public class AppreciationController {

    private final AppreciationService appreciationService;
    private final PeriodeService periodeService;
    private final TuteurService tuteurService;
    private final EvaluationService evaluationService;
    private final ModelMapper modelMapper;
    private final CategorieService categorieService;

    public AppreciationController(AppreciationService appreciationService,
                                  PeriodeService periodeService,
                                  TuteurService tuteurService,
                                  EvaluationService evaluationService,
                                  CompetenceService competenceService,
                                  ModelMapper modelMapper, CategorieService categorieService) {
        this.appreciationService = appreciationService;
        this.periodeService = periodeService;
        this.tuteurService = tuteurService;
        this.evaluationService = evaluationService;
        this.modelMapper = modelMapper;
        this.categorieService = categorieService;
    }

    @GetMapping
    public List<AppreciationDTO> getAll() {
        return appreciationService.findAll().stream().map(app -> {
            AppreciationDTO dto = new AppreciationDTO();
            dto.setId(app.getId());
            dto.setPeriodeId(app.getPeriode().getId());
            dto.setTuteurId(app.getTuteur().getId());
            dto.setEvaluationIds(
                    app.getEvaluations().stream().map(Evaluation::getId).collect(Collectors.toList())
            );
            dto.setCategorieIds(
                    app.getCategories().stream().map(Categorie::getId).collect(Collectors.toList())
            );
            return dto;
        }).collect(Collectors.toList());
    }

    @PostMapping
    public AppreciationDTO create(@RequestBody AppreciationDTO dto) {
        Appreciation appreciation = new Appreciation();
        appreciation.setPeriode(periodeService.findById(dto.getPeriodeId()));
        appreciation.setTuteur(tuteurService.findById(dto.getTuteurId()));

        // Ajoute les évaluations et lie chaque à l'appréciation
        List<Evaluation> evaluations = dto.getEvaluationIds().stream()
                .map(evaluationService::findById)
                .peek(eval -> eval.setAppreciation(appreciation)) // <- LIAISON ICI
                .collect(Collectors.toList());
        appreciation.setEvaluations(evaluations);

        // Ajoute les catégories et lie chaque à l'appréciation
        List<Categorie> categories = dto.getCategorieIds().stream()
                .map(categorieService::findById)
                .peek(cat -> cat.setAppreciation(appreciation)) // <- LIAISON ICI
                .collect(Collectors.toList());
        appreciation.setCategories(categories);

        Appreciation saved = appreciationService.save(appreciation);

        // DTO à retourner
        AppreciationDTO result = new AppreciationDTO();
        result.setId(saved.getId());
        result.setPeriodeId(saved.getPeriode().getId());
        result.setTuteurId(saved.getTuteur().getId());
        result.setEvaluationIds(saved.getEvaluations().stream().map(Evaluation::getId).collect(Collectors.toList()));
        result.setCategorieIds(saved.getCategories().stream().map(Categorie::getId).collect(Collectors.toList()));
        return result;
    }

}
