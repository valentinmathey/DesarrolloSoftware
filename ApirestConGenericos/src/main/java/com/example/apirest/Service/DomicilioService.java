package com.example.apirest.Service;

import com.example.apirest.Entity.Domicilio;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface DomicilioService extends BaseService<Domicilio, Long>{
    List<Domicilio> findByCalleContaining(String calle) throws Exception;

    List<Domicilio> findByNumero(int numero) throws Exception;

    List<Domicilio> findByLocalidadId(Long localidadId) throws Exception;

    long countDomiciliosByLocalidadId(Long localidadId) throws Exception;

    Page<Domicilio> findByCalleContainingWithPagination(String calle, Pageable pageable) throws Exception;

    Page<Domicilio> findByLocalidadIdWithPagination(Long localidadId, Pageable pageable) throws Exception;
}
