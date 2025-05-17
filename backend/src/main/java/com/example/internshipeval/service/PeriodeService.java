package com.example.internshipeval.service;

import com.example.internshipeval.model.Periode;
import com.example.internshipeval.model.Stagiaire;
import com.example.internshipeval.model.Tuteur;
import com.example.internshipeval.repositorie.PeriodeRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PeriodeService {
    private final PeriodeRepository periodeRepository;

    public PeriodeService(PeriodeRepository periodeRepository) {
        this.periodeRepository = periodeRepository;
    }

    public List<Periode> findAll() {
        return periodeRepository.findAll();
    }

    public Periode findById(Long id) {
        return periodeRepository.findById(id).orElse(null);
    }

    public Periode save(Periode periode) {
        return periodeRepository.save(periode);
    }

    public void delete(Long id) {
        periodeRepository.deleteById(id);
    }
    public Periode createWithTuteurAndStagiaire(LocalDate dateDebut, LocalDate dateFin, Stagiaire stagiaire, Tuteur tuteur) {
        Periode periode = new Periode();
        periode.setDateDebut(dateDebut);
        periode.setDateFin(dateFin);
        periode.setStagiaire(stagiaire);
        periode.setTuteurs(List.of(tuteur));
        return periodeRepository.save(periode);
    }

}
