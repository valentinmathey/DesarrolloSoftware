package com.example.apirest.Service;

import com.example.apirest.Entity.Localidad;
import com.example.apirest.Repository.LocalidadRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocalidadServiceImpl implements LocalidadService{

    @Autowired
    private LocalidadRepository localidadRepository;

    @Override
    public List<Localidad> findAll() throws Exception {
        try {
            return localidadRepository.findAll();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Localidad findById(Long id) throws Exception {
        try {
            Optional<Localidad> localidadOptional = localidadRepository.findById(id);
            return localidadOptional.orElseThrow(() -> new Exception("Localidad no encontrada"));
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Localidad save(Localidad entity) throws Exception {
        try {
            return localidadRepository.save(entity);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Localidad update(Long id, Localidad entity) throws Exception {
        try {
            Optional<Localidad> localidadOptional = localidadRepository.findById(id);
            Localidad localidadToUpdate = localidadOptional.orElseThrow(() -> new Exception("Localidad no encontrada"));
            localidadToUpdate = localidadRepository.save(entity);
            return localidadToUpdate;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean delete(Long id) throws Exception {
        try {
            if (localidadRepository.existsById(id)) {
                localidadRepository.deleteById(id);
                return true;
            } else {
                throw new Exception("Localidad no encontrada");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}
