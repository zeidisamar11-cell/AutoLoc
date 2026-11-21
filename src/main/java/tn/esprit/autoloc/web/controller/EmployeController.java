package tn.esprit.autoloc.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Employe;
import tn.esprit.autoloc.service.IEmployeService;
import java.util.List;
@RestController
@RequestMapping("/api/employes")
@RequiredArgsConstructor
public class EmployeController{
    private final IEmployeService employeService;
    @PostMapping
    public Employe ajouterEmploye(@RequestBody Employe employe){
        return employeService.ajouterEmploye(employe);
    }
    @PutMapping
    public Employe modifierEmploye(@RequestBody Employe employe){
        return employeService.modifierEmploye(employe);
    }
    @GetMapping
    public List<Employe> afficherTousEmployes() {
        return employeService.afficherTousEmployes();
    }
    @GetMapping("/{id}")
    public Employe afficherEmployeById(@PathVariable Long id) {
        return employeService.afficherEmployeById(id);
    }
    @DeleteMapping("/{id}")
    public void supprimerEmploye(@PathVariable Long id){
        employeService.supprimerEmploye(id);
    }
    @PutMapping("/desaffecterEmploye/{idEmploye}")
    public Employe desaffecterEmploye(@PathVariable Long idEmploye){
        return employeService.desaffecterEmploye(idEmploye);
    }
    @PutMapping("/affecterEmploye/{idEmploye}/{idAgence}")
    public Employe affecterEmploye(@PathVariable Long idEmploye, @PathVariable Long idAgence){
        return employeService.affecterEmploye(idEmploye, idAgence);
    }
}