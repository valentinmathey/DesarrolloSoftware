package com.example.apirest.Service;

import com.example.apirest.Entity.Localidad;
import com.example.apirest.Repository.BaseRepository;
import com.example.apirest.Repository.LocalidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocalidadServiceImpl extends BaseServiceImpl<Localidad, Long> implements LocalidadService{

    @Autowired
    private LocalidadRepository localidadRepository;

    public LocalidadServiceImpl(BaseRepository<Localidad, Long> baseRepository) {
        super(baseRepository);
    }

    @Override
    public List<Localidad> findByDenominacionContaining(String denominacion) throws Exception {
        try {
            return localidadRepository.findByDenominacionContaining(denominacion);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public long countDomiciliosByLocalidadId(Long localidadId) throws Exception {
        try {
            return localidadRepository.countDomiciliosByLocalidadId(localidadId);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<Localidad> findLocalidadesWithoutDomicilios() throws Exception {
        try {
            return localidadRepository.findLocalidadesWithoutDomicilios();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<Localidad> findByDenominacionContainingWithPagination(String denominacion, Pageable pageable) throws Exception {
        try {
            return localidadRepository.findByDenominacionContainingWithPagination(denominacion, pageable);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
