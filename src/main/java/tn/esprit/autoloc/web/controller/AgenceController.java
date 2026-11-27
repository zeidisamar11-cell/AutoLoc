package tn.esprit.autoloc.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Agence;
import tn.esprit.autoloc.service.IAgenceService;
import java.util.List;
@RestController
@RequestMapping("/api/agences")
@RequiredArgsConstructor
public class AgenceController {
    private final IAgenceService agenceService;
    @PostMapping
    public Agence ajouterAgence(@RequestBody Agence agence) {
        return agenceService.ajouterAgence(agence);
    }
    @PutMapping
    public Agence modifierAgence(@RequestBody Agence agence) {
        return agenceService.modifierAgence(agence);
    }
    @GetMapping
    public List<Agence> afficherToutesAgences() {
        return agenceService.afficherToutesAgences();
    }
    @GetMapping("/{id}")
    public Agence afficherAgenceById(@PathVariable Long id) {
        return agenceService.afficherAgenceById(id);
    }
    @DeleteMapping("/{id}")
    public void supprimerAgence(@PathVariable Long id) {
        agenceService.supprimerAgence(id);
    }
    @PostMapping("/ajouterAgenceEtAffecterVehicules")
    public Agence ajouterAgenceEtAffecterVehicules(@RequestBody Agence agence){
        return agenceService.ajouterAgenceEtAffecterVehicules(agence);
    }
    @GetMapping("/ville/{ville}")
    public List<Agence> retournerAgenceParVille(@PathVariable String ville) {
        return agenceService.retournerAgenceParVille(ville);
    }
}