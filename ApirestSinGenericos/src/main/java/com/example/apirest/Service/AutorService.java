package com.example.apirest.Service;


import com.example.apirest.Entity.Autor;

import java.util.List;

public interface AutorService {

    public List<Autor> findAll() throws Exception;
    public Autor findById(Long id) throws Exception;
    public Autor save(Autor entity) throws Exception;
    public Autor update(Long id, Autor entity) throws Exception;
    public boolean delete(Long id) throws Exception;

}
