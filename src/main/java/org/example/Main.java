// src/main/java/org.example.rentacarapi/Main.java (Se for o pacote correto)

package org.example.rentacarapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// A anotação @SpringBootApplication combina @Configuration,
// @EnableAutoConfiguration e @ComponentScan.
// Ela é crucial para o Spring encontrar todos os seus controllers, services e repositórios.
@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        // Inicializa a aplicação Spring Boot
        SpringApplication.run(Main.class, args);
    }
}