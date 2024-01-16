package com.produit.produitservice.config;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "global.params")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class GlobalConfig {
    int p1;
    int p2;
}
