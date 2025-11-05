// src/main/java/org.example.rentacarapi.repository/CarroRepository.java

package org.example.rentacarapi.repository;

import org.example.rentacarapi.model.model.Carro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // 1. Opcional no JpaRepository, mas boa prática
// 2. Extende JpaRepository: o primeiro parâmetro é a Entidade, o segundo é o tipo do ID
public interface CarroRepository extends JpaRepository<Carro, Long> {

    // O Spring já gera os métodos: save(), findById(), findAll(), delete(), etc.

    // Podemos adicionar métodos personalizados que o Spring implementa automaticamente:

    // Exemplo de método para o requisito opcional (Filtro por categoria):
    // List<Carro> findByCategoria(String categoria);

}
