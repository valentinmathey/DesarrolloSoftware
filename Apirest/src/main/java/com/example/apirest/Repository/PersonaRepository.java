package com.example.apirest.Repository;

import com.example.apirest.Entity.Persona;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends BaseRepository<Persona, Long> {
}
