package com.example.apirest.Service;

import com.example.apirest.Entity.Domicilio;
import com.example.apirest.Repository.BaseRepository;
import com.example.apirest.Repository.DomicilioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DomicilioServiceImpl extends BaseServiceImpl<Domicilio, Long> implements DomicilioService{

    @Autowired
    private DomicilioRepository domicilioRepository;


    public DomicilioServiceImpl(BaseRepository<Domicilio, Long> baseRepository) {
        super(baseRepository);
    }

    @Override
    public List<Domicilio> findByCalleContaining(String calle) throws Exception {
        try {
            return domicilioRepository.findByCalleContaining(calle);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<Domicilio> findByNumero(int numero) throws Exception {
        try {
            return domicilioRepository.findByNumero(numero);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<Domicilio> findByLocalidadId(Long localidadId) throws Exception {
        try {
            return domicilioRepository.findByLocalidadId(localidadId);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public long countDomiciliosByLocalidadId(Long localidadId) throws Exception {
        try {
            return domicilioRepository.countDomiciliosByLocalidadId(localidadId);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<Domicilio> findByCalleContainingWithPagination(String calle, Pageable pageable) throws Exception {
        try {
            return domicilioRepository.findByCalleContainingWithPagination(calle, pageable);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<Domicilio> findByLocalidadIdWithPagination(Long localidadId, Pageable pageable) throws Exception {
        try {
            return domicilioRepository.findByLocalidadIdWithPagination(localidadId, pageable);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
