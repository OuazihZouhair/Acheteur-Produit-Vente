package com.achteur.achteurservice.produits;

import org.springframework.cloud.openfeign.FeignClient;
import com.achteur.achteurservice.model.Produit;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="PRODUIT-SERVICE")
public interface ProduitFindController {

    @GetMapping("/pro/produits")
    public List<Produit> findAll();

    @GetMapping("/pro/produits/{id}")
    public Produit findById(@PathVariable("id") Integer id);
}
