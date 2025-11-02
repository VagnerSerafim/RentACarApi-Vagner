// src/main/java/org.example.rentacarapi.model/Carro.java

package org.example.rentacarapi.model.model;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;

// Usando 'jakarta' para Spring Boot 3+

@Entity
@Data   // Gera Getters, Setters, toString, hashCode, equals
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String modelo;
    private String marca;

    // Categorias como SUV, EXECUTIVO, ECONOMICO, etc.
    private String categoria;

    private Double potenciaMotor; // Ex: 120.0 (CV ou HP)
    private Integer anoFabricacao;

    // BigDecimal é crucial para valores monetários
    private BigDecimal precoDiaria;

    private boolean disponivel = true;

    // --- Rastreamento (Para atender ao requisito de nome do colega) ---
    @Column(nullable = false)
    private String criadoPor;

    // Data/hora que o registro foi criado
    private LocalDateTime dataCriacao = LocalDateTime.now();

}
