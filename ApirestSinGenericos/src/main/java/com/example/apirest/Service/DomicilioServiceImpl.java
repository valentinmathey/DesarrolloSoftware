package com.example.apirest.Service;

import com.example.apirest.Entity.Domicilio;
import com.example.apirest.Repository.DomicilioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DomicilioServiceImpl implements DomicilioService{

    @Autowired
    private DomicilioRepository domicilioRepository;

    @Override
    public List<Domicilio> findAll() throws Exception {
        try {
            return domicilioRepository.findAll();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Domicilio findById(Long id) throws Exception {
        try {
            Optional<Domicilio> domicilioOptional = domicilioRepository.findById(id);
            return domicilioOptional.orElseThrow(() -> new Exception("Domicilio no encontrado"));
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Domicilio save(Domicilio entity) throws Exception {
        try {
            return domicilioRepository.save(entity);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Domicilio update(Long id, Domicilio entity) throws Exception {
        try {
            Optional<Domicilio> domicilioOptional = domicilioRepository.findById(id);
            Domicilio domicilioToUpdate = domicilioOptional.orElseThrow(() -> new Exception("Domicilio no encontrado"));
            domicilioToUpdate = domicilioRepository.save(entity);
            return domicilioToUpdate;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean delete(Long id) throws Exception {
        try {
            if (domicilioRepository.existsById(id)) {
                domicilioRepository.deleteById(id);
                return true;
            } else {
                throw new Exception("Domicilio no encontrado");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}
