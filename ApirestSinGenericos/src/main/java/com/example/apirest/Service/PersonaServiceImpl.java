package com.example.apirest.Service;

import com.example.apirest.Entity.Persona;
import com.example.apirest.Repository.PersonaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaServiceImpl implements PersonaService{

    @Autowired
    private PersonaRepository personaRepository;

    @Override
    public List<Persona> findAll() throws Exception {
        try {
            return personaRepository.findAll();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Persona findById(Long id) throws Exception {
        try {
            Optional<Persona> personaOptional = personaRepository.findById(id);
            return personaOptional.orElseThrow(() -> new Exception("Persona no encontrada"));
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Persona save(Persona entity) throws Exception {
        try {
            return personaRepository.save(entity);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Persona update(Long id, Persona entity) throws Exception {
        try {
            Optional<Persona> personaOptional = personaRepository.findById(id);
            Persona personaToUpdate = personaOptional.orElseThrow(() -> new Exception("Persona no encontrada"));
            personaToUpdate = personaRepository.save(entity);
            return personaToUpdate;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean delete(Long id) throws Exception {
        try {
            if (personaRepository.existsById(id)) {
                personaRepository.deleteById(id);
                return true;
            } else {
                throw new Exception("Persona no encontrada");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}
