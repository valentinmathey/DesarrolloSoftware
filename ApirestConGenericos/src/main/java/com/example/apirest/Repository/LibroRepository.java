package com.example.apirest.Repository;

import com.example.apirest.Entity.Libro;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface LibroRepository extends BaseRepository<Libro, Long> {

    // Buscar libros por una parte del título
    @Query("SELECT l FROM Libro l WHERE l.titulo LIKE %:titulo%")
    List<Libro> findByTituloContaining(@Param("titulo") String titulo);

    // Buscar libros por género
    @Query("SELECT l FROM Libro l WHERE l.genero = :genero")
    List<Libro> findByGenero(@Param("genero") String genero);

    // Buscar libros publicados entre dos fechas
    @Query("SELECT l FROM Libro l WHERE l.fecha BETWEEN :startDate AND :endDate")
    List<Libro> findByFechaBetween(@Param("startDate") Date startDate, @Param("endDate") Date endDate);

    // Contar cuántos libros tiene asignados una persona
    @Query("SELECT COUNT(l) FROM Libro l WHERE l.persona.id = :personaId")
    long countLibrosByPersonaId(@Param("personaId") Long personaId);

    // Buscar libros por un autor específico
    @Query("SELECT l FROM Libro l JOIN l.autores a WHERE a.id = :autorId")
    List<Libro> findByAutorId(@Param("autorId") Long autorId);

    // Contar libros con más de X páginas
    @Query("SELECT l FROM Libro l WHERE l.paginas > :paginas")
    List<Libro> findByPaginasGreaterThan(@Param("paginas") int paginas);

    // Buscar libros por título con paginación
    @Query("SELECT l FROM Libro l WHERE l.titulo LIKE %:titulo%")
    Page<Libro> findByTituloContainingWithPagination(@Param("titulo") String titulo, Pageable pageable);

    // Buscar libros por género con paginación
    @Query("SELECT l FROM Libro l WHERE l.genero = :genero")
    Page<Libro> findByGeneroWithPagination(@Param("genero") String genero, Pageable pageable);


}
