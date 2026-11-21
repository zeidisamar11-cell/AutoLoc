package tn.esprit.autoloc.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.service.IVehiculeService;
import java.util.List;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
@RestController
@RequestMapping("/api/vehicules")
@Tag(name = "Véhicules", description = "Gestion des véhicules d'AutoLoc")
@RequiredArgsConstructor
public class VehiculeController {
    private final IVehiculeService vehiculeService;
    @Operation(summary = "Ajouter un véhicule")
    @PostMapping
    public Vehicule ajouterVehicule(@RequestBody Vehicule vehicule){
        return vehiculeService.ajouterVehicule(vehicule);
    }
    @PutMapping
    public Vehicule modifierVehicule(@RequestBody Vehicule vehicule){
        return vehiculeService.modifierVehicule(vehicule);
    }
    @GetMapping
    public List<Vehicule> afficherTousVehicules() {
        return vehiculeService.afficherTousVehicules();
    }
    @GetMapping("/{id}")
    public Vehicule afficherVehiculeById(@PathVariable Long id) {
        return vehiculeService.afficherVehiculeById(id);
    }
    @DeleteMapping("/{id}")
    public void supprimerVehicule(@PathVariable Long id) {
        vehiculeService.supprimerVehicule(id);
    }
    @PutMapping("/affecterEquipement/{idVehicule}/{idEquipement}")
    public Vehicule affecterEquipement(@PathVariable Long idVehicule, @PathVariable Long idEquipement){
        return vehiculeService.affecterEquipement(idVehicule, idEquipement);
    }
    @PutMapping("/desaffecterEquipement/{idVehicule}/{idEquipement}")
    public Vehicule desaffecterEquipement(@PathVariable Long idVehicule, @PathVariable Long idEquipement){
        return vehiculeService.desaffecterEquipement(idVehicule, idEquipement);
    }
}