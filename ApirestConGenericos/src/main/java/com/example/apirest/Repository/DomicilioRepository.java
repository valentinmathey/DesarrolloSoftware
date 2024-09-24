package com.example.apirest.Repository;

import com.example.apirest.Entity.Domicilio;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DomicilioRepository extends BaseRepository<Domicilio, Long> {

    // Buscar domicilios por una parte del nombre de la calle
    @Query("SELECT d FROM Domicilio d WHERE d.calle LIKE %:calle%")
    List<Domicilio> findByCalleContaining(@Param("calle") String calle);

    // Buscar domicilios por número de domicilio
    @Query("SELECT d FROM Domicilio d WHERE d.numero = :numero")
    List<Domicilio> findByNumero(@Param("numero") int numero);

    // Buscar domicilios por localidad
    @Query("SELECT d FROM Domicilio d WHERE d.localidad.id = :localidadId")
    List<Domicilio> findByLocalidadId(@Param("localidadId") Long localidadId);

    // Contar cuántos domicilios están asociados a una localidad específica
    @Query("SELECT COUNT(d) FROM Domicilio d WHERE d.localidad.id = :localidadId")
    long countDomiciliosByLocalidadId(@Param("localidadId") Long localidadId);

    // Buscar domicilios por calle con paginación
    @Query("SELECT d FROM Domicilio d WHERE d.calle LIKE %:calle%")
    Page<Domicilio> findByCalleContainingWithPagination(@Param("calle") String calle, Pageable pageable);

    // Buscar domicilios por localidad con paginación
    @Query("SELECT d FROM Domicilio d WHERE d.localidad.id = :localidadId")
    Page<Domicilio> findByLocalidadIdWithPagination(@Param("localidadId") Long localidadId, Pageable pageable);

}
