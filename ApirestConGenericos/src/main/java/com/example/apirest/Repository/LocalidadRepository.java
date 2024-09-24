package com.example.apirest.Repository;

import com.example.apirest.Entity.Localidad;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LocalidadRepository extends BaseRepository<Localidad, Long> {

    // Buscar localidades por una parte de la denominación
    @Query("SELECT l FROM Localidad l WHERE l.denominacion LIKE %:denominacion%")
    List<Localidad> findByDenominacionContaining(@Param("denominacion") String denominacion);

    // Contar cuántos domicilios están asociados a una localidad
    @Query("SELECT COUNT(d) FROM Localidad l JOIN l.libros d WHERE l.id = :localidadId")
    long countDomiciliosByLocalidadId(@Param("localidadId") Long localidadId);

    // Obtener todas las localidades que no tienen domicilios asociados
    @Query("SELECT l FROM Localidad l WHERE SIZE(l.libros) = 0")
    List<Localidad> findLocalidadesWithoutDomicilios();

    // Buscar localidades por denominación con paginación
    @Query("SELECT l FROM Localidad l WHERE l.denominacion LIKE %:denominacion%")
    Page<Localidad> findByDenominacionContainingWithPagination(@Param("denominacion") String denominacion, Pageable pageable);
}
