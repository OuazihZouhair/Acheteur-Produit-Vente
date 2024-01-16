package com.vente.venteservice.web;

import com.vente.venteservice.achteurs.AchteurFeignController;
import com.vente.venteservice.entities.Vente;
import com.vente.venteservice.modele.Achteur;
import com.vente.venteservice.modele.Produit;
import com.vente.venteservice.produits.ProduitFeignController;
import com.vente.venteservice.repositories.VenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ven")
public class VenteController {
    @Autowired
    VenteRepository venteRepository;

    @Autowired
    ProduitFeignController produitFeignController;

    @Autowired
    AchteurFeignController achteurFeignController;

    @GetMapping("/ventes")
    public List<Vente> getAll(){
        List<Vente> lv = venteRepository.findAll();

        List<Produit> lp = produitFeignController.findAll();
        List<Achteur> la = achteurFeignController.findAll();

        for(Vente v : lv)
            for(Produit p : lp)
                if(v.getIdp() == p.getIdp()){
                    v.setProduit(p);
                    break;
                }

        for(Vente v : lv)
            for(Achteur a : la)
                if(v.getIda() == a.getIda()){
                    v.setAchteur(a);
                    break;
                }

        return lv;
    }

    @GetMapping("/ventes/{id}")
    public Vente getId(@PathVariable("id") Integer id){
        Vente v = venteRepository.findById(id).get();

        Produit p = produitFeignController.findById(v.getIdp());
        v.setProduit(p);

        Achteur a = achteurFeignController.findById(v.getIda());
        v.setAchteur(a);

        return v;
    }

    @PutMapping("/ventes/{id}")
    public void update(@PathVariable("id") Integer id, @RequestBody Vente vente){
        Vente v = venteRepository.findById(id).get();

        if(vente.getIda() != null)
            v.setIda(vente.getIda());
        if(vente.getIdp() != null)
            v.setIdp(vente.getIdp());
        if(vente.getQuantite() != null)
            v.setQuantite(vente.getQuantite());
        if(vente.getMois() != null)
            v.setMois(vente.getMois());
        if(vente.getAnnee() != null)
            v.setAnnee(vente.getAnnee());

        venteRepository.save(v);
    }

    @PostMapping("/ventes")
    public void save(@RequestBody Vente vente){
        venteRepository.save(vente);
    }

    @DeleteMapping("/ventes/{id}")
    public void supp(@PathVariable("id") Integer id){
        venteRepository.deleteById(id);
    }
}
