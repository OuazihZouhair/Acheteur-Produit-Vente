package com.achteur.achteurservice;

import com.achteur.achteurservice.entities.Achteur;
import com.achteur.achteurservice.repositories.AchteurRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@EnableFeignClients
public class AchteurServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AchteurServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(AchteurRepository achteurRepository){
        return args -> {

           /* for(int i=0; i<5; i++){
                Achteur a = Achteur.builder()
                        .nom("Zouhair")
                        .ville("Rabat")
                        .build();
                achteurRepository.save(a);
            }*/
            /*Achteur a1 = new Achteur();
            a1.setNom("Zouhair");
            a1.setVille("Rabat");
            a1.setIdp(1);
            achteurRepository.save(a1);*/

            Achteur a1 = Achteur.builder().nom("Zouhair").ville("Rabat").idp(1).build();
            achteurRepository.save(a1);

            /*Achteur a2 = new Achteur();
            a2.setNom("Noureddine");
            a2.setVille("Béni Mellal");
            a2.setIdp(2);*/

            Achteur a2 = Achteur.builder().nom("Noureddine").ville("Béni Mellal").idp(2).build();
            achteurRepository.save(a2);

            List<Achteur> listes = achteurRepository.findAll();
            System.out.println("-----------------------------");
            System.out.println("Nom ------------ Ville ");
            for(Achteur a : listes){
                System.out.println(a.getNom() + "------------" + a.getVille());
            }

        };
    }

}
