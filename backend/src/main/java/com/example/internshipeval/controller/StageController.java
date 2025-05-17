package com.example.internshipeval.controller;

import com.example.internshipeval.dto.StageDTO;
import com.example.internshipeval.model.Stage;
import com.example.internshipeval.service.StageService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/stages")
public class StageController {

    private final StageService stageService;
    private final ModelMapper modelMapper;

    public StageController(StageService service, ModelMapper mapper) {
        this.stageService = service;
        this.modelMapper = mapper;
    }

    @GetMapping
    public List<StageDTO> getAll() {
        return stageService.findAll().stream()
                .map(s -> modelMapper.map(s, StageDTO.class))
                .collect(Collectors.toList());
    }
    @PostMapping
    public StageDTO create(@RequestBody StageDTO dto) {
        Stage entity = modelMapper.map(dto, Stage.class);
        Stage saved = stageService.save(entity);
        return modelMapper.map(saved, StageDTO.class);
    }


    @GetMapping("/{id}")
    public StageDTO getById(@PathVariable Long id) {
        return modelMapper.map(stageService.findById(id), StageDTO.class);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        stageService.delete(id);
    }
}
