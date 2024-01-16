package com.vente.venteservice.achteurs;

import com.vente.venteservice.modele.Achteur;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="ACHTEUR-SERVICE")
public interface AchteurFeignController {

    @GetMapping("/ach/achteurs")
    public List<Achteur> findAll();

    @GetMapping("/ach/achteurs/{id}")
    public Achteur findById(@PathVariable("id") Integer id);
}
