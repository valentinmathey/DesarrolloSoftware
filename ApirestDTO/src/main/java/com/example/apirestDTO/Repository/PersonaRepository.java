package com.example.apirestDTO.Repository;

import com.example.apirestDTO.Domain.Entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona, Long> {
}
