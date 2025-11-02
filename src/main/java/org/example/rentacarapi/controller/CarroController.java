// src/main/java/org/example/rentacarapi/controller/CarroController.java

package org.example.rentacarapi.controller;

import org.example.rentacarapi.dto.CarroRequestDTO;
import org.example.rentacarapi.model.model.Carro;
import org.example.rentacarapi.model.service.CarroService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // 1. Marca a classe como um controlador REST
@RequestMapping("/carros") // 2. Define a rota base para todos os métodos
public class CarroController {

    // Injeção de dependência do Service
    @Autowired
    private CarroService carroService;

    // =======================================================
    // === ENDPOINT OBRIGATÓRIO: POST para criar um registro ===
    // =======================================================
    @PostMapping
    public ResponseEntity<Carro> cadastrarCarro(@RequestBody CarroRequestDTO carroDTO) {

        // Chama o método de serviço, que inclui a lógica de adicionar o nome do colega
        Carro novoCarro = carroService.cadastrar(carroDTO);

        // Retorna o objeto criado com o status 201 Created
        return new ResponseEntity<>(novoCarro, HttpStatus.CREATED);
    }

    // NOTA: Os demais endpoints do CRUD (GET, PUT, DELETE, PATCH) virão depois.

}
