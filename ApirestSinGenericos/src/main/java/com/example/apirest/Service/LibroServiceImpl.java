package com.example.apirest.Service;

import com.example.apirest.Entity.Libro;
import com.example.apirest.Repository.LibroRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroServiceImpl implements LibroService{

    @Autowired
    private LibroRepository libroRepository;

    @Override
    public List<Libro> findAll() throws Exception {
        try {
            return libroRepository.findAll();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Libro findById(Long id) throws Exception {
        try {
            Optional<Libro> libroOptional = libroRepository.findById(id);
            return libroOptional.orElseThrow(() -> new Exception("Libro no encontrado"));
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Libro save(Libro entity) throws Exception {
        try {
            return libroRepository.save(entity);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Libro update(Long id, Libro entity) throws Exception {
        try {
            Optional<Libro> libroOptional = libroRepository.findById(id);
            Libro libroToUpdate = libroOptional.orElseThrow(() -> new Exception("Libro no encontrado"));
            libroToUpdate = libroRepository.save(entity);
            return libroToUpdate;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean delete(Long id) throws Exception {
        try {
            if (libroRepository.existsById(id)) {
                libroRepository.deleteById(id);
                return true;
            } else {
                throw new Exception("Libro no encontrado");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}
