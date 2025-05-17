package com.example.internshipeval.controller;

import com.example.internshipeval.dto.PeriodeDTO;
import com.example.internshipeval.model.Periode;
import com.example.internshipeval.model.Tuteur;
import com.example.internshipeval.service.PeriodeService;
import com.example.internshipeval.service.StageService;
import com.example.internshipeval.service.StagiaireService;
import com.example.internshipeval.service.TuteurService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/periodes")
public class PeriodeController {

    private final PeriodeService periodeService;
    private final StageService stageService;
    private final StagiaireService stagiaireService;
    private final TuteurService tuteurService;
    private final ModelMapper modelMapper;

    public PeriodeController(PeriodeService periodeService,
                             StageService stageService,
                             StagiaireService stagiaireService,
                             TuteurService tuteurService,
                             ModelMapper modelMapper) {
        this.periodeService = periodeService;
        this.stageService = stageService;
        this.stagiaireService = stagiaireService;
        this.tuteurService = tuteurService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public List<PeriodeDTO> getAll() {
        return periodeService.findAll().stream()
                .map(p -> {
                    PeriodeDTO dto = modelMapper.map(p, PeriodeDTO.class);
                    dto.setStageId(p.getStage().getId());
                    dto.setStagiaireId(p.getStagiaire().getId());
                    dto.setTuteurIds(p.getTuteurs().stream().map(Tuteur::getId).collect(Collectors.toList()));
                    return dto;
                })
                .collect(Collectors.toList());
    }

    @PostMapping
    public PeriodeDTO create(@RequestBody PeriodeDTO dto) {
        Periode periode = new Periode();
        periode.setDateDebut(dto.getDateDebut());
        periode.setDateFin(dto.getDateFin());

        periode.setStage(stageService.findById(dto.getStageId()));
        periode.setStagiaire(stagiaireService.findById(dto.getStagiaireId()));

        List<Tuteur> tuteurs = dto.getTuteurIds().stream()
                .map(tuteurService::findById)
                .collect(Collectors.toList());
        periode.setTuteurs(tuteurs);

        Periode saved = periodeService.save(periode);

        // ✅ mapping manuel pour le DTO retourné
        PeriodeDTO response = new PeriodeDTO();
        response.setDateDebut(saved.getDateDebut());
        response.setDateFin(saved.getDateFin());
        response.setStageId(saved.getStage().getId());
        response.setStagiaireId(saved.getStagiaire().getId());
        response.setTuteurIds(saved.getTuteurs()
                .stream()
                .map(Tuteur::getId)
                .collect(Collectors.toList()));

        return response;
    }

}

