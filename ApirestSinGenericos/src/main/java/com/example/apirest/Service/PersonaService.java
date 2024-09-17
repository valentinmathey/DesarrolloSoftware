package com.example.apirest.Service;

import com.example.apirest.Entity.Persona;

import java.util.List;

public interface PersonaService {

    public List<Persona> findAll() throws Exception;
    public Persona findById(Long id) throws Exception;
    public Persona save(Persona entity) throws Exception;
    public Persona update(Long id, Persona entity) throws Exception;
    public boolean delete(Long id) throws Exception;

}
