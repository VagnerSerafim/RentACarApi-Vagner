// src/main/java/org.example.rentacarapi.model/LocalDeAluguel.java

package org.example.rentacarapi.model.model;

import lombok.Data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@Data
public class LocalDeAluguel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome; // Ex: "Matriz Centro", "Ponto Retirada Aeroporto"

    // O CEP será o valor de entrada para a API externa
    private String cep;

    // Campos preenchidos via API de CEP
    private String logradouro;
    private String bairro;
    private String cidade;
    private String uf; // Estado
}
