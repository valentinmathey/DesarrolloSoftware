package com.example.apirest.Service;

import com.example.apirest.Entity.Localidad;

import java.util.List;

public interface LocalidadService {

    public List<Localidad> findAll() throws Exception;
    public Localidad findById(Long id) throws Exception;
    public Localidad save(Localidad entity) throws Exception;
    public Localidad update(Long id, Localidad entity) throws Exception;
    public boolean delete(Long id) throws Exception;

}
