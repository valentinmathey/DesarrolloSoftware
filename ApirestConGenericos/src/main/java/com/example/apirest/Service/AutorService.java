package com.example.apirest.Service;

import com.example.apirest.Entity.Autor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AutorService extends BaseService<Autor, Long>{
    List<Autor> findByNombreContaining(String nombre) throws Exception;

    List<Autor> findByNombreAndApellido(String nombre, String apellido) throws Exception;

    List<Autor> findByLibroId(Long libroId) throws Exception;

    List<Autor> findAutoresWithMultipleLibros() throws Exception;

    List<Autor> findByBibliografiaContaining(String texto) throws Exception;

    Page<Autor> findByNombreContainingWithPagination(String nombre, Pageable pageable) throws Exception;

    Page<Autor> findByNombreAndApellidoWithPagination(String nombre, String apellido, Pageable pageable) throws Exception;

}
