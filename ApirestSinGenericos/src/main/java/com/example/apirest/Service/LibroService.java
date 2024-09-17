package com.example.apirest.Service;

import com.example.apirest.Entity.Libro;

import java.util.List;

public interface LibroService {

    public List<Libro> findAll() throws Exception;
    public Libro findById(Long id) throws Exception;
    public Libro save(Libro entity) throws Exception;
    public Libro update(Long id, Libro entity) throws Exception;
    public boolean delete(Long id) throws Exception;

}
