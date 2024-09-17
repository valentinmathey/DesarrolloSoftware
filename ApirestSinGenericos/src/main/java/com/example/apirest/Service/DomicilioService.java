package com.example.apirest.Service;

import com.example.apirest.Entity.Domicilio;

import java.util.List;

public interface DomicilioService {

    public List<Domicilio> findAll() throws Exception;
    public Domicilio findById(Long id) throws Exception;
    public Domicilio save(Domicilio entity) throws Exception;
    public Domicilio update(Long id, Domicilio entity) throws Exception;
    public boolean delete(Long id) throws Exception;

}
