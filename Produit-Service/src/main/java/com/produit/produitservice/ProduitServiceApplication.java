package com.produit.produitservice;

import com.produit.produitservice.config.GlobalConfig;
import com.produit.produitservice.entities.Produit;
import com.produit.produitservice.repositories.ProduitRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@EnableConfigurationProperties({GlobalConfig.class})
public class ProduitServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProduitServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner startp(ProduitRepository produitRepository){
        return args -> {
            Produit p1 = Produit.builder().marque("Computer HP")
                            .description("HP EliteBook 8g ram 256g rom 14p")
                            .prix(2860.00).quantite(10).build();
            produitRepository.save(p1);

            /*p1.setMarque("Computer HP");
            p1.setDescription("HP EliteBook 8g ram 256g rom 14p");
            p1.setPrix(2860.00);
            p1.setQuantite(10);*/


            Produit p2 = Produit.builder().marque("Computer ASUS")
                    .description("ASUS 16g ram 512g rom 15p")
                    .prix(4000.00).quantite(13).build();
            produitRepository.save(p2);


            Produit p3 = Produit.builder().marque("Computer MSI")
                    .description("MSI 32g ram 1To rom 15.6p")
                    .prix(11000.00).quantite(5).build();
            produitRepository.save(p3);


            /*p2.setMarque("Computer ASUS");
            p2.setDescription("ASUS 16g ram 512g rom 15p");
            p2.setPrix(4000.50);
            p2.setQuantite(13);*/


            List<Produit> liste = produitRepository.findAll();
            System.out.println("-----------------------------");
            System.out.println("Marque ------------- Description -------------------------------------- Prix ------------- Quantite");
            for(Produit p : liste)
                System.out.println(p.getMarque() + "-------------" + p.getDescription() + "-------------" + p.getPrix() + "-------------" + p.getQuantite());
        };
    }
}
