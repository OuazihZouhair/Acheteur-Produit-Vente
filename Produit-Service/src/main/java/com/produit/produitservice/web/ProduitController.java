package com.produit.produitservice.web;

import com.produit.produitservice.config.GlobalConfig;
import com.produit.produitservice.entities.Produit;
import com.produit.produitservice.repositories.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pro")
public class ProduitController {

    @Autowired
    ProduitRepository produitRepository;

    @Autowired
    GlobalConfig globalConfig;

    @GetMapping("globalconfig")
    public GlobalConfig getGlobalConfig(){
        return globalConfig;
    }

    @GetMapping("/produits")
    public List<Produit> getAll(){
        return produitRepository.findAll();
    }

    @GetMapping("/produits/{id}")
    public Produit getId(@PathVariable("id") Integer id){
        return produitRepository.findById(id).get();
    }

    @PutMapping("/produits/{id}")
    public void put(@PathVariable("id") Integer id, @RequestBody Produit prod){
        Produit p = produitRepository.findById(id).get();

        if(prod.getMarque() != null)
            p.setMarque(prod.getMarque());
        if(prod.getDescription() != null)
            p.setDescription(prod.getDescription());
        if(prod.getPrix() != null)
            p.setPrix(prod.getPrix());
        if(prod.getQuantite() != null)
            p.setQuantite(prod.getQuantite());

        produitRepository.save(p);
    }

    @PostMapping("/produits")
    public void save(@RequestBody Produit pro){
        produitRepository.save(pro);
    }

    @DeleteMapping("produits/{id}")
    public void supp(@PathVariable("id") Integer id){
        produitRepository.deleteById(id);
    }

}
