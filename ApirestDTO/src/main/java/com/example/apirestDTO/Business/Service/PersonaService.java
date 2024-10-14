package com.example.apirestDTO.Business.Service;

import com.example.apirestDTO.Domain.Entity.Persona;

public interface PersonaService {

    Persona crear(Persona persona);
    Persona getById(Long id);
}
