package com.example.apirestDTO.Business.Service;

import com.example.apirestDTO.Domain.Entity.Persona;
import com.example.apirestDTO.Repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class PersonaServiceImp implements PersonaService{

    @Autowired
    private PersonaRepository personaRepository;


    @Override
    public Persona crear(Persona persona) {
        return personaRepository.save(persona);
    }

    @Override
    public Persona getById(Long id) {
        Optional<Persona> persona = personaRepository.findById(id);
        if(persona.isEmpty()) throw new RuntimeException("No hay ninguna persona con el id " + id);
        return persona.get();
    }
}
