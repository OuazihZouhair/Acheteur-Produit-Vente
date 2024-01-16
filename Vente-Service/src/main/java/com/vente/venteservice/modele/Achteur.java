package com.vente.venteservice.modele;

import lombok.*;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor @ToString @Builder
public class Achteur {
    private Integer ida;
    private String nom;
    private String ville;
    private Integer idp;
    //private Produit produit;
}
