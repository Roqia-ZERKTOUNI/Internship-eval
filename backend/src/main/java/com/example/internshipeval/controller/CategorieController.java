package com.example.internshipeval.controller;

import com.example.internshipeval.dto.CategorieDTO;
import com.example.internshipeval.model.Categorie;
import com.example.internshipeval.service.CategorieService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/categories")
public class CategorieController {

    @Autowired
    private CategorieService categorieService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public CategorieDTO create(@RequestBody CategorieDTO dto) {
        Categorie entity = modelMapper.map(dto, Categorie.class);
        return modelMapper.map(categorieService.save(entity), CategorieDTO.class);
    }

    @GetMapping
    public List<CategorieDTO> getAll() {
        return categorieService.findAll().stream()
                .map(cat -> modelMapper.map(cat, CategorieDTO.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public CategorieDTO getById(@PathVariable Long id) {
        return modelMapper.map(categorieService.findById(id), CategorieDTO.class);
    }

    @PutMapping("/{id}")
    public CategorieDTO update(@PathVariable Long id, @RequestBody CategorieDTO dto) {
        dto.setId(id);
        Categorie entity = modelMapper.map(dto, Categorie.class);
        return modelMapper.map(categorieService.update(id, entity), CategorieDTO.class);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        categorieService.delete(id);
    }
}
