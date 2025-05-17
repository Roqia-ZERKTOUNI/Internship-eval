package com.example.internshipeval.controller;
import com.example.internshipeval.dto.*;
import com.example.internshipeval.model.*;
import com.example.internshipeval.service.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
@CrossOrigin(origins = "http://localhost:3000") // Assurez-vous que le frontend peut accéder à l'API
@RequestMapping("/api/evaluation-globale")
public class EvaluationGlobaleController {

    private final AppreciationService appreciationService;
    private final EvaluationService evaluationService;
    private final CategorieService categorieService;
    private final CompetenceService competenceService;
    private final TuteurService tuteurService;
    private final StagiaireService stagiaireService;
    private final PeriodeService periodeService;
    private final StageService stageService;

    public EvaluationGlobaleController(
            AppreciationService appreciationService,
            EvaluationService evaluationService,
            CategorieService categorieService,
            CompetenceService competenceService,
            TuteurService tuteurService,
            StagiaireService stagiaireService,
            PeriodeService periodeService,
            StageService stageService) {
        this.appreciationService = appreciationService;
        this.evaluationService = evaluationService;
        this.categorieService = categorieService;
        this.competenceService = competenceService;
        this.tuteurService = tuteurService;
        this.stagiaireService = stagiaireService;
        this.periodeService = periodeService;
        this.stageService = stageService;
    }

    @PostMapping("/save")
    public ResponseEntity<?> enregistrerEvaluation(@RequestBody EvaluationGlobaleDTO dto) {
        // 1. Tuteur, Stagiaire, Periode, Stage
        Tuteur tuteur = tuteurService.findOrCreate(
                dto.getNomTuteur(), dto.getPrenomTuteur(), dto.getEmailTuteur(), dto.getEntreprise()
        );
        Stagiaire stagiaire = stagiaireService.findOrCreate(
                dto.getNomStagiaire(), dto.getPrenomStagiaire(), dto.getEmailStagiaire(), dto.getInstitution()
        );
        Stage stage = new Stage();
        stage.setStagiaire(stagiaire);
        stage.setEntreprise(dto.getEntreprise());
        stage.setDescription(dto.getDescription());
        stage.setObjectif(dto.getObjectif());
        stage = stageService.save(stage);

        Periode periode = periodeService.createWithTuteurAndStagiaire(dto.dateDebut, dto.dateFin, stagiaire, tuteur);

        // 2. Appréciation
        Appreciation appreciation = new Appreciation();
        appreciation.setPeriode(periode);
        appreciation.setTuteur(tuteur);
        periode.setStagiaire(stagiaire);
        periode.setStage(stage);
        appreciation = appreciationService.save(appreciation);

        // 3. Évaluation
        Evaluation eval = new Evaluation();
        eval.setAppreciation(appreciation);
        eval.setImplication(Enum.valueOf(Implication.class, dto.implication));
        eval.setOuverture(Enum.valueOf(Ouverture.class, dto.ouverture));
        eval.setQualiteProductions(Enum.valueOf(QualiteProduction.class, dto.qualiteProductions));
        eval.setObservations(dto.observations);
        evaluationService.save(eval);

        // 4. LOG + Création des catégories + compétences
        for (CategorieCompetenceDTO catDTO : dto.getCategories()) {
            System.out.println(">>> 📂 Catégorie reçue : " + catDTO.getIntitule());
            System.out.println(">>> 📝 Note : " + catDTO.getNote());

            if (catDTO.getCompetences() == null || catDTO.getCompetences().isEmpty()) {
                System.out.println("⚠️ Aucune compétence reçue pour cette catégorie.");
            } else {
                System.out.println("✅ Nombre de compétences : " + catDTO.getCompetences().size());
            }

            Categorie cat = new Categorie();
            cat.setAppreciation(appreciation);
            cat.setIntitule(catDTO.getIntitule());
            cat.setNote(catDTO.getNote());
            cat = categorieService.save(cat);
            System.out.println("✅ ID inséré pour la catégorie : " + cat.getId());


            if (catDTO.getCompetences() != null) {
                for (CompetenceDTO compDTO : catDTO.getCompetences()) {
                    System.out.println("   🔧 → Compétence : " + compDTO.getIntitule() + " | Niveau : " + compDTO.getNiveau());
                    Competence comp = new Competence();
                    comp.setCategorie(cat);
                    comp.setIntitule(compDTO.getIntitule());
                    comp.setNiveau(compDTO.getNiveau());
                    competenceService.save(comp);
                }
            }
        }

        return ResponseEntity.ok("✅ Évaluation enregistrée avec succès !");
    }


}
