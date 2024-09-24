package com.example.apirest.Service;

import com.example.apirest.Entity.Persona;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PersonaService extends BaseService<Persona, Long>{
    List<Persona> search(String filtro) throws Exception;

    List<Persona> findByNombreAndApellido(String nombre, String apellido) throws Exception;

    List<Persona> findPersonasConLibros() throws Exception;

    List<Persona> findPersonasByLibroTitulo(String titulo) throws Exception;

    long countPersonasByDomicilioId(Long domicilioId) throws Exception;

    List<Persona> findPersonasConMultipleLibros() throws Exception;

    // Métodos para JPQL y SQL Nativo
    List<Persona> searchJPQL(String filtro) throws Exception;

    List<Persona> searchNativo(String filtro) throws Exception;

    //Metodo para JPQL y SQL Nativo con Pages
    Page<Persona> searchJPQLWithPagination(String filtro, Pageable pageable) throws Exception;

    Page<Persona> searchNativoWithPagination(String filtro, Pageable pageable) throws Exception;


}
