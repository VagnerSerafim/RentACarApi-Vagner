// src/main/java/org.example.rentacarapi.controller/CarroController.java

package org.example.rentacarapi.controller;

import org.example.rentacarapi.dto.CarroRequestDTO;
import org.example.rentacarapi.model.Carro;
import org.example.rentacarapi.service.CarroService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carros") // Rota base: http://localhost:8080/carros
public class CarroController {

    @Autowired
    private CarroService carroService;

    // =======================================================
    // 1. POST /carros (CRIAR)
    // =======================================================
    @PostMapping
    public ResponseEntity<Carro> cadastrarCarro(@RequestBody CarroRequestDTO carroDTO) {
        // O Service aplica a regra de preencher o 'criadoPor'
        Carro novoCarro = carroService.cadastrar(carroDTO);
        // Retorna 201 Created
        return new ResponseEntity<>(novoCarro, HttpStatus.CREATED);
    }

    // =======================================================
    // 2. GET /carros (BUSCAR TODOS)
    // =======================================================
    @GetMapping
    public ResponseEntity<List<Carro>> buscarTodos() {
        List<Carro> carros = carroService.buscarTodos();
        return ResponseEntity.ok(carros);
    }

    // =======================================================
    // 3. GET /carros/{id} (BUSCAR POR ID)
    // =======================================================
    @GetMapping("/{id}")
    public ResponseEntity<Carro> buscarPorId(@PathVariable Long id) {
        return carroService.buscarPorId(id)
                           .map(ResponseEntity::ok) // Se encontrar, retorna 200 OK
                           .orElseGet(() -> ResponseEntity.notFound().build()); // Se não, retorna 404 Not Found
    }

    // =======================================================
    // 4. PUT /carros/{id} (ATUALIZAÇÃO COMPLETA)
    // =======================================================
    @PutMapping("/{id}")
    public ResponseEntity<Carro> atualizarCarro(@PathVariable Long id, @RequestBody CarroRequestDTO carroDTO) {
        return carroService.atualizar(id, carroDTO)
                           .map(ResponseEntity::ok) // Se atualizar, retorna 200 OK
                           .orElseGet(() -> ResponseEntity.notFound().build()); // Se o ID não existir, retorna 404
    }

    // =======================================================
    // 5. DELETE /carros/{id} (DELETAR)
    // =======================================================
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCarro(@PathVariable Long id) {
        if (carroService.deletar(id)) {
            // Se deletado com sucesso, retorna 204 No Content
            return ResponseEntity.noContent().build();
        }
        // Se o ID não existir, retorna 404 Not Found (ou 204, dependendo da regra de negócio)
        return ResponseEntity.notFound().build();
    }

    // =======================================================
    // 6. PATCH /carros/{id} (ATUALIZAÇÃO PARCIAL)
    // =======================================================
    // IMPORTANTE: O corpo desta requisição usa a Entidade Carro,
    // pois a lógica de PATCH é mais fácil de implementar assim no Service.
    @PatchMapping("/{id}")
    public ResponseEntity<Carro> atualizarParcialmente(@PathVariable Long id, @RequestBody Carro detalhes) {
        return carroService.atualizarParcialmente(id, detalhes)
                           .map(ResponseEntity::ok)
                           .orElseGet(() -> ResponseEntity.notFound().build());
    }
}