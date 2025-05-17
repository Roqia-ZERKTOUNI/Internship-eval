package com.example.internshipeval.controller;

import com.example.internshipeval.dto.EvaluationDTO;
import com.example.internshipeval.model.Evaluation;
import com.example.internshipeval.model.Implication;
import com.example.internshipeval.model.Ouverture;
import com.example.internshipeval.model.QualiteProduction;
import com.example.internshipeval.service.AppreciationService;
import com.example.internshipeval.service.EvaluationService;
import com.example.internshipeval.service.PeriodeService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/evaluations")
public class EvaluationController {

    private final EvaluationService evaluationService;
    private final AppreciationService appreciationService;
    private final ModelMapper modelMapper;

    public EvaluationController(EvaluationService evaluationService, AppreciationService appreciationService,
                                 ModelMapper modelMapper) {
        this.evaluationService = evaluationService;
        this.appreciationService = appreciationService;
        this.modelMapper = modelMapper;
    }

    @PostMapping
    public EvaluationDTO create(@RequestBody EvaluationDTO dto) {
        Evaluation evaluation = new Evaluation();

        // Conversion explicite String -> Enum
        evaluation.setImplication(Implication.valueOf(dto.getImplication()));
        evaluation.setOuverture(Ouverture.valueOf(dto.getOuverture()));
        evaluation.setQualiteProductions(QualiteProduction.valueOf(dto.getQualiteProductions()));

        evaluation.setObservations(dto.getObservations());

        if (dto.getAppreciationId() != null) {
            evaluation.setAppreciation(appreciationService.findById(dto.getAppreciationId()));
        } else {
            evaluation.setAppreciation(null);
        }

        Evaluation saved = evaluationService.save(evaluation);

        // Préparer DTO à retourner
        EvaluationDTO result = new EvaluationDTO();
        result.setId(saved.getId());
        result.setImplication(saved.getImplication().name());
        result.setOuverture(saved.getOuverture().name());
        result.setQualiteProductions(saved.getQualiteProductions().name());
        result.setObservations(saved.getObservations());
        if (saved.getAppreciation() != null) {
            result.setAppreciationId(saved.getAppreciation().getId());
        } else {
            result.setAppreciationId(null);
        }

        return result;
    }


    @GetMapping
    public List<EvaluationDTO> getAll() {
        return evaluationService.findAll().stream()
                .map(e -> modelMapper.map(e, EvaluationDTO.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public EvaluationDTO getById(@PathVariable Long id) {
        return modelMapper.map(evaluationService.findById(id), EvaluationDTO.class);
    }

    @PutMapping("/{id}")
    public EvaluationDTO update(@PathVariable Long id, @RequestBody EvaluationDTO dto) {
        dto.setId(id);
        Evaluation evaluation = modelMapper.map(dto, Evaluation.class);
        if (dto.getAppreciationId() != null) {
            evaluation.setAppreciation(appreciationService.findById(dto.getAppreciationId()));
        } else {
            evaluation.setAppreciation(null);
        }
        return modelMapper.map(evaluationService.update(id, evaluation), EvaluationDTO.class);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        evaluationService.delete(id);
    }
}
