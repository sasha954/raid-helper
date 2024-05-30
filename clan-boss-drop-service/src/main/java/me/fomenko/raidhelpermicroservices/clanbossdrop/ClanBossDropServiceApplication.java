package me.fomenko.raidhelpermicroservices.clanbossdrop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ClanBossDropServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClanBossDropServiceApplication.class, args);
    }
}
