// src/main/java/org.example.rentacarapi.dto/CarroRequestDTO.java

package org.example.rentacarapi.dto;

import lombok.Data;
import java.math.BigDecimal;

@Data // Gera Getters e Setters
public class CarroRequestDTO {

    // NOTA: Não incluímos ID, criadoPor ou dataCriacao, pois são gerados pelo sistema.

    private String modelo;
    private String marca;
    private String categoria;
    private Double potenciaMotor;
    private Integer anoFabricacao;
    private BigDecimal precoDiaria;
}