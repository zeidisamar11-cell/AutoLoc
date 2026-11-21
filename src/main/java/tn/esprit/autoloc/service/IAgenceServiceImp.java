package tn.esprit.autoloc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Agence;
import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.repository.AgenceRepository;
import tn.esprit.autoloc.repository.VehiculeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;
import java.util.List;
@Service
@RequiredArgsConstructor
@Slf4j

public class IAgenceServiceImp implements IAgenceService {
    private final AgenceRepository agenceRepository;
  private final VehiculeRepository vehiculeRepository;
    @Override
    public Agence ajouterAgence(Agence agence) {
        return agenceRepository.save(agence);
    }
    @Override
    public Agence modifierAgence(Agence agence){
        return agenceRepository.save(agence) ;
    }
    @Override
    public List<Agence> afficherToutesAgences(){
        return agenceRepository.findAll();
    }
    @Override
    public Agence afficherAgenceById(Long id){
        return agenceRepository.findById(id).orElse(null);
    }
    @Override
    public void supprimerAgence(Long id) {
        agenceRepository.deleteById(id);
    }
    @Override
    public Agence ajouterAgenceEtAffecterVehicules(Agence agence) {
        Agence savedAgence = agenceRepository.save(agence);
        for (Vehicule vehicule : agence.getVehicules()) {
            vehicule.setAgence(savedAgence);
            vehiculeRepository.save(vehicule);
        }
        return savedAgence;
    }
    @Scheduled(fixedDelay=2,timeUnit=TimeUnit.MINUTES)
    public void suivreNombreAgences(){
        List<Agence> agences=agenceRepository.findAll();
        log.info("Suivi des agences- nombre total :"+agences.size());
        log.info("Date et heure de la vérification :"+LocalDateTime.now());
    }
}
