package tn.esprit.autoloc.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Contrat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idContrat;
    LocalDate dateSignature;
    BigDecimal montantTotal;
    boolean valide;
    @JsonIgnore
    @OneToOne(mappedBy = "contrat")
    Reservation reservation;
    @JsonIgnore
    @OneToMany(mappedBy = "contrat",cascade = CascadeType.ALL)
    List<Paiement>paiementlist=new ArrayList<>();
}