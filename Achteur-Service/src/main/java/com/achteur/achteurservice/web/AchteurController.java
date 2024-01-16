package com.achteur.achteurservice.web;

import com.achteur.achteurservice.entities.Achteur;
import com.achteur.achteurservice.model.Produit;
import com.achteur.achteurservice.produits.ProduitFindController;
import com.achteur.achteurservice.repositories.AchteurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/ach")
public class AchteurController {

    @Autowired
    AchteurRepository achteurRepository;

    @Autowired
    private ProduitFindController produitFindController;

    @GetMapping("/achteurs")
    public List<Achteur> getAll(){
        List<Achteur> la = achteurRepository.findAll();

        /*List<Produit> lp = produitFindController.findAll();

        for(Achteur a : la)
            for(Produit p : lp)
                if(a.getIdp() == p.getIdp()) {
                    a.setProduit(p);
                    //achteurRepository.save(a);
                    break;
                }*/

        return la;
    }

    @GetMapping("/achteurs/{id}")
    public Achteur getId( @PathVariable("id") Integer id){
        Achteur e = achteurRepository.findById(id).get();

        /*Produit p = produitFindController.findById(e.getIdp());
        e.setProduit(p);*/

        return e;
    }

    @PutMapping("/achteurs/{id}")
    public void save(@PathVariable("id") Integer id, @RequestBody Achteur ach){
        Achteur a = achteurRepository.findById(id).get();

        if(ach.getNom() != null)
            a.setNom(ach.getNom());
        if(ach.getVille() != null)
            a.setVille(ach.getVille());

        achteurRepository.save(a);
    }

    @PostMapping("/achteurs")
    public void save(@RequestBody Achteur a){
        achteurRepository.save(a);
    }

    @DeleteMapping("/achteurs/{id}")
    public void supprimer(@PathVariable("id") Integer id){
        achteurRepository.deleteById(id);
    }
}
