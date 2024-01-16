package com.achteur.achteurservice.repositories;

import com.achteur.achteurservice.entities.Achteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

@RepositoryRestController
public interface AchteurRepository extends JpaRepository<Achteur, Integer> {

}
