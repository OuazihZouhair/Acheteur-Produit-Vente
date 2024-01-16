package com.vente.venteservice;

import com.vente.venteservice.entities.Vente;
import com.vente.venteservice.repositories.VenteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@EnableFeignClients
public class VenteServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(VenteServiceApplication.class, args);
    }


    @Bean
    CommandLineRunner startv(VenteRepository venteRepository){
        return args -> {
          Vente v1 = Vente.builder()
                  .ida(1)
                  .idp(1)
                  .quantite(5)
                  .mois(12)
                  .annee(2023)
                  .build();
          venteRepository.save(v1);

          Vente v2 = Vente.builder()
                  .ida(2)
                  .idp(2)
                  .quantite(9)
                  .mois(11)
                  .annee(2023)
                  .build();
          venteRepository.save(v2);

            List<Vente> liste = venteRepository.findAll();
            System.out.println("--------------------------------------------");
            System.out.println("ida------idp----------Quantité-----------Mois------------Année");
            for(Vente v : liste)
                System.out.println(v.getIda() + "------" + v.getIdp() + "----------" + v.getQuantite() + "-----------" + v.getMois() + "------------" + v.getAnnee());
        };
    }
}
