package tn.esprit.autoloc.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Equipement;
import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.repository.EquipementRepository;
import tn.esprit.autoloc.repository.VehiculeRepository;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class IVehiculeServiceImp implements IVehiculeService {
    private final VehiculeRepository vehiculeRepository;
    private final EquipementRepository equipementRepository;
    @Override
    public Vehicule ajouterVehicule(Vehicule vehicule) {
        return vehiculeRepository.save(vehicule);
    }
    @Override
    public Vehicule modifierVehicule(Vehicule vehicule) {
        return vehiculeRepository.save(vehicule);
    }
    @Override
    public List<Vehicule> afficherTousVehicules() {
        return vehiculeRepository.findAll();
    }
    @Override
    public Vehicule afficherVehiculeById(Long id) {
        return vehiculeRepository.findById(id).orElse(null);
    }
    @Override
    public void supprimerVehicule(Long id) {
        vehiculeRepository.deleteById(id);
    }
    @Override
    public Vehicule affecterEquipement(Long idVehicule, Long idEquipement) {
        Vehicule vehicule = vehiculeRepository.findById(idVehicule).get();
        Equipement equipement = equipementRepository.findById(idEquipement).get();
        vehicule.getEquipements().add(equipement);
        return vehiculeRepository.save(vehicule);
    }
    @Override
    public Vehicule desaffecterEquipement(Long idVehicule, Long idEquipement) {
        Vehicule vehicule = vehiculeRepository.findById(idVehicule).get();
        Equipement equipement = equipementRepository.findById(idEquipement).get();
        vehicule.getEquipements().remove(equipement);
        return vehiculeRepository.save(vehicule);
    }
    @Scheduled(initialDelay =5,fixedRate=60,timeUnit=TimeUnit.SECONDS)
    public void actualiserEtatVehicules(){
        List<Vehicule>vehicules=vehiculeRepository.findAll();
        log.info("Actualisation des véhicules- nombre total :"+vehicules.size());
        log.info("Date et heure de l'actualisation:"+LocalDateTime.now());}

    @Scheduled(cron = "0 0 9 ? * MON")
    public void genererRapportVehicules(){
        List<Vehicule> vehicules=vehiculeRepository.findAll();
        int total=vehicules.size();
        log.info("Rapport hebdomadaire des véhicules");
        log.info("Nombre total de véhicules : " + total);
        log.info("Rapport généré le:"+LocalDateTime.now());}
}
