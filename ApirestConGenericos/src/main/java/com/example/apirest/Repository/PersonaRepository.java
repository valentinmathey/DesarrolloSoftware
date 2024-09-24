package com.example.apirest.Repository;

import com.example.apirest.Entity.Persona;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonaRepository extends BaseRepository<Persona, Long> {

    List<Persona> findByNombreContainingOrApellidoContaining(String nombre, String apellido);

    boolean existsByDni(int dni);

    List<Persona> findByNombreAndApellido(String nombre, String apellido);

    // Query con JPQL
    @Query(value = "SELECT p FROM Persona p WHERE p.nombre LIKE %:filtro% OR p.apellido LIKE %:filtro%")
    List<Persona> search(@Param("filtro") String filtro);

    // Query con SQL Nativo
    @Query(
            value = "SELECT * FROM persona WHERE persona.nombre LIKE %:filtro% OR persona.apellido LIKE %:filtro%",
            nativeQuery = true
    )
    List<Persona> searchNativo(@Param("filtro") String filtro);

    // Obtener personas con libros asignados
    @Query("SELECT p FROM Persona p JOIN p.libros l WHERE SIZE(p.libros) > 0")
    List<Persona> findPersonasConLibros();

    // Buscar por coincidencia en libros asignados
    @Query("SELECT p FROM Persona p JOIN p.libros l WHERE l.titulo LIKE %:titulo%")
    List<Persona> findPersonasByLibroTitulo(@Param("titulo") String titulo);

    //Contar personas por domicilio
    @Query("SELECT COUNT(p) FROM Persona p WHERE p.domicilio.id = :domicilioId")
    long countPersonasByDomicilioId(@Param("domicilioId") Long domicilioId);

    //Buscar personas con múltiples libros
    @Query("SELECT p FROM Persona p WHERE SIZE(p.libros) > 1")
    List<Persona> findPersonasConMultipleLibros();

    // Optimización de consultas JPQL y SQL Nativo con Pages
    @Query(value = "SELECT p FROM Persona p WHERE p.nombre LIKE %:filtro% OR p.apellido LIKE %:filtro%")
    Page<Persona> searchJPQLWithPagination(@Param("filtro") String filtro, Pageable pageable);

    @Query(
            value = "SELECT * FROM persona WHERE persona.nombre LIKE %:filtro% OR persona.apellido LIKE %:filtro%",
            countQuery = "SELECT count(*) FROM persona",
            nativeQuery = true
    )
    Page<Persona> searchNativoWithPagination(@Param("filtro") String filtro, Pageable pageable);

}
