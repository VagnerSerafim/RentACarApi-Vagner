// src/main/java/org.example.rentacarapi.repository/LocalDeAluguelRepository.java

package org.example.rentacarapi.model.repository;

import org.example.rentacarapi.model.model.LocalDeAluguel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocalDeAluguelRepository extends JpaRepository<LocalDeAluguel, Long> {

    // Métodos CRUD para LocalDeAluguel
}