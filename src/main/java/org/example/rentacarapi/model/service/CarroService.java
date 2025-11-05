// src/main/java/org.example.rentacarapi.service/CarroService.java

package org.example.rentacarapi.service;

import org.example.rentacarapi.dto.CarroRequestDTO;
import org.example.rentacarapi.model.model.Carro;
import org.example.rentacarapi.repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CarroService {

    @Autowired
    private CarroRepository carroRepository;

    // 1. POST (CRIAR)
    public Carro cadastrar(CarroRequestDTO dto) {

        Carro novoCarro = new Carro();

        // Mapeamento DTO para Entidade
        novoCarro.setModelo(dto.getModelo());
        novoCarro.setMarca(dto.getMarca());
        novoCarro.setCategoria(dto.getCategoria());
        novoCarro.setPotenciaMotor(dto.getPotenciaMotor());
        novoCarro.setAnoFabricacao(dto.getAnoFabricacao());
        novoCarro.setPrecoDiaria(dto.getPrecoDiaria());

        // LÓGICA DE NEGÓCIO: Rastreamento (Nome do Colega)
        novoCarro.setCriadoPor("Vagner Serafim"); // <--- Mantenha apenas esta
        novoCarro.setDataCriacao(LocalDateTime.now());

        return carroRepository.save(novoCarro);
    }

    // 2. GET (BUSCAR TODOS)
    public List<Carro> buscarTodos() {
        return carroRepository.findAll();
    }

    // 3. GET (BUSCAR POR ID)
    public Optional<Carro> buscarPorId(Long id) {
        return carroRepository.findById(id);
    }

    // 4. PUT (ATUALIZAÇÃO COMPLETA)
    public Optional<Carro> atualizar(Long id, CarroRequestDTO dto) {
        return carroRepository.findById(id).map(carroExistente -> {
            carroExistente.setModelo(dto.getModelo());
            carroExistente.setMarca(dto.getMarca());
            carroExistente.setCategoria(dto.getCategoria());
            carroExistente.setPotenciaMotor(dto.getPotenciaMotor());
            carroExistente.setAnoFabricacao(dto.getAnoFabricacao());
            carroExistente.setPrecoDiaria(dto.getPrecoDiaria());
            return carroRepository.save(carroExistente);
        });
    }

    // 5. DELETE (DELETAR)
    public boolean deletar(Long id) {
        if (carroRepository.existsById(id)) {
            carroRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // 6. PATCH (ATUALIZAÇÃO PARCIAL)
    public Optional<Carro> atualizarParcialmente(Long id, Carro carroDetalhes) {
        return carroRepository.findById(id).map(carroExistente -> {

            // Exemplo: Atualizar somente o preço diária ou a disponibilidade
            if (carroDetalhes.getPrecoDiaria() != null) {
                carroExistente.setPrecoDiaria(carroDetalhes.getPrecoDiaria());
            }

            if (carroDetalhes.getModelo() != null) {
                carroExistente.setModelo(carroDetalhes.getModelo());
            }
            // Você pode adicionar mais campos aqui

            return carroRepository.save(carroExistente);
        });
    }

}