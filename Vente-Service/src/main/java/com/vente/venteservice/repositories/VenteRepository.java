package com.vente.venteservice.repositories;

import com.vente.venteservice.entities.Vente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

@RepositoryRestController
public interface VenteRepository extends JpaRepository<Vente, Integer> {

}
