package com.vente.venteservice.entities;

import com.vente.venteservice.modele.Achteur;
import com.vente.venteservice.modele.Produit;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString @Builder
public class Vente {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idv;

    private Integer ida;
    private Integer idp;

    private Integer quantite;
    private Integer mois;
    private Integer annee;

    @Transient
    private Achteur achteur;
    @Transient
    private Produit produit;

}
