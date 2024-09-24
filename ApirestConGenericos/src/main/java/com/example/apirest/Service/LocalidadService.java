package com.example.apirest.Service;

import com.example.apirest.Entity.Localidad;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface LocalidadService extends BaseService<Localidad, Long>{

    List<Localidad> findByDenominacionContaining(String denominacion) throws Exception;

    long countDomiciliosByLocalidadId(Long localidadId) throws Exception;

    List<Localidad> findLocalidadesWithoutDomicilios() throws Exception;

    Page<Localidad> findByDenominacionContainingWithPagination(String denominacion, Pageable pageable) throws Exception;
}
