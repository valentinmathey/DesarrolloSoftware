package com.example.apirest.Repository;

import com.example.apirest.Entity.Autor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AutorRepository extends BaseRepository<Autor, Long>{
    // Buscar autores por una parte del nombre
    @Query("SELECT a FROM Autor a WHERE a.nombre LIKE %:nombre%")
    List<Autor> findByNombreContaining(@Param("nombre") String nombre);

    // Buscar autores por nombre y apellido combinados
    @Query("SELECT a FROM Autor a WHERE a.nombre = :nombre AND a.apellido = :apellido")
    List<Autor> findByNombreAndApellido(@Param("nombre") String nombre, @Param("apellido") String apellido);

    // Buscar autores que han escrito un libro específico
    @Query("SELECT a FROM Autor a JOIN a.libros l WHERE l.id = :libroId")
    List<Autor> findByLibroId(@Param("libroId") Long libroId);

    // Contar autores con más de un libro
    @Query("SELECT a FROM Autor a WHERE SIZE(a.libros) > 1")
    List<Autor> findAutoresWithMultipleLibros();

    // Buscar autores por una parte de la bibliografía
    @Query("SELECT a FROM Autor a WHERE a.bibliografia LIKE %:texto%")
    List<Autor> findByBibliografiaContaining(@Param("texto") String texto);

    // Buscar autores por nombre con paginación
    @Query("SELECT a FROM Autor a WHERE a.nombre LIKE %:nombre%")
    Page<Autor> findByNombreContainingWithPagination(@Param("nombre") String nombre, Pageable pageable);

    // Buscar autores por nombre y apellido con paginación
    @Query("SELECT a FROM Autor a WHERE a.nombre = :nombre AND a.apellido = :apellido")
    Page<Autor> findByNombreAndApellidoWithPagination(@Param("nombre") String nombre, @Param("apellido") String apellido, Pageable pageable);
}
