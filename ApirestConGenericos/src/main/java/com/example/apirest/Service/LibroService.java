package com.example.apirest.Service;

import com.example.apirest.Entity.Libro;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;

public interface LibroService extends BaseService<Libro, Long>{
    List<Libro> findByTituloContaining(String titulo) throws Exception;

    List<Libro> findByGenero(String genero) throws Exception;

    List<Libro> findByFechaBetween(Date startDate, Date endDate) throws Exception;

    long countLibrosByPersonaId(Long personaId) throws Exception;

    List<Libro> findByAutorId(Long autorId) throws Exception;

    List<Libro> findByPaginasGreaterThan(int paginas) throws Exception;

    Page<Libro> findByTituloContainingWithPagination(String titulo, Pageable pageable) throws Exception;

    Page<Libro> findByGeneroWithPagination(String genero, Pageable pageable) throws Exception;
}
