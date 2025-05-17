package com.example.internshipeval.controller;

import com.example.internshipeval.dto.StagiaireDTO;
import com.example.internshipeval.model.Stagiaire;
import com.example.internshipeval.service.StagiaireService;
import org.modelmapper.ModelMapper;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
@SpringBootApplication(scanBasePackages = "com.example")

@RestController
@RequestMapping("/api/stagiaires")
public class StagiaireController {

    private final StagiaireService stagiaireService;
    private final ModelMapper modelMapper;

    public StagiaireController(StagiaireService service, ModelMapper mapper) {
        this.stagiaireService = service;
        this.modelMapper = mapper;
    }

    @GetMapping
    public List<StagiaireDTO> getAll() {
        return stagiaireService.findAll().stream()
                .map(st -> modelMapper.map(st, StagiaireDTO.class))
                .collect(Collectors.toList());
    }


    @PostMapping
    public StagiaireDTO create(@RequestBody StagiaireDTO dto) {
        Stagiaire entity = modelMapper.map(dto, Stagiaire.class);
        return modelMapper.map(stagiaireService.save(entity), StagiaireDTO.class);
    }

    @GetMapping("/{id}")
    public StagiaireDTO getById(@PathVariable Long id) {
        return modelMapper.map(stagiaireService.findById(id), StagiaireDTO.class);
    }
    @PutMapping("/api/stagiaires/{id}")
    public StagiaireDTO update(@PathVariable Long id, @RequestBody StagiaireDTO dto) {
        dto.setId(id);
        Stagiaire entity = modelMapper.map(dto, Stagiaire.class);
        return modelMapper.map(stagiaireService.update(id, entity), StagiaireDTO.class);
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        stagiaireService.delete(id);
    }
}
