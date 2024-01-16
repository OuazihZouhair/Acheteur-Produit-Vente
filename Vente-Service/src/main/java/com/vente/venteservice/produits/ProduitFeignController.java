package com.vente.venteservice.produits;

import com.vente.venteservice.modele.Produit;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="PRODUIT-SERVICE")
public interface ProduitFeignController {

    @GetMapping("/pro/produits")
    public List<Produit> findAll();

    @GetMapping("/pro/produits/{id}")
    public Produit findById(@PathVariable("id") Integer id);
}
