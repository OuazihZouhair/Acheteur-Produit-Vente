package com.achteur.achteurservice.entities;

import com.achteur.achteurservice.model.Produit;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter @AllArgsConstructor @NoArgsConstructor @ToString @Builder
public class Achteur {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ida;

    private String nom;
    private String ville;
    private Integer idp;

    /*
    @Transient
    private Produit produit;*/
}
