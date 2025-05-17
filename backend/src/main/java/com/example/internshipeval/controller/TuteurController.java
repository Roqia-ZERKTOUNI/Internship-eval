package com.example.internshipeval.controller;

import com.example.internshipeval.dto.TuteurDTO;
import com.example.internshipeval.model.Tuteur;
import com.example.internshipeval.service.TuteurService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/tuteurs")
public class TuteurController {

    private final TuteurService tuteurService;
    private final ModelMapper modelMapper;

    public TuteurController(TuteurService service, ModelMapper mapper) {
        this.tuteurService = service;
        this.modelMapper = mapper;
    }

    @GetMapping
    public List<TuteurDTO> getAll() {
        return tuteurService.findAll().stream()
                .map(t -> modelMapper.map(t, TuteurDTO.class))
                .collect(Collectors.toList());
    }

    @PostMapping
    public TuteurDTO create(@RequestBody TuteurDTO dto) {
        Tuteur entity = modelMapper.map(dto, Tuteur.class);
        return modelMapper.map(tuteurService.save(entity), TuteurDTO.class);
    }

    @GetMapping("/{id}")
    public TuteurDTO getById(@PathVariable Long id) {
        return modelMapper.map(tuteurService.findById(id), TuteurDTO.class);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        tuteurService.delete(id);
    }
}

