package com.achteur.achteurservice.model;

import lombok.*;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor @ToString @Builder
public class Produit {
    private Integer idp;
    private String marque;
    private String description;
    private Double prix;
    private Integer quantite;
}
