package com.example.apirest.Service;

import com.example.apirest.Entity.Autor;
import com.example.apirest.Repository.AutorRepository;
import com.example.apirest.Repository.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorServiceImpl extends BaseServiceImpl<Autor, Long> implements AutorService{

    @Autowired
    private AutorRepository autorRepository;

    public AutorServiceImpl(BaseRepository<Autor, Long> baseRepository) {
        super(baseRepository);
    }

    @Override
    public List<Autor> findByNombreContaining(String nombre) throws Exception {
        try {
            return autorRepository.findByNombreContaining(nombre);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<Autor> findByNombreAndApellido(String nombre, String apellido) throws Exception {
        try {
            return autorRepository.findByNombreAndApellido(nombre, apellido);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<Autor> findByLibroId(Long libroId) throws Exception {
        try {
            return autorRepository.findByLibroId(libroId);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<Autor> findAutoresWithMultipleLibros() throws Exception {
        try {
            return autorRepository.findAutoresWithMultipleLibros();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<Autor> findByBibliografiaContaining(String texto) throws Exception {
        try {
            return autorRepository.findByBibliografiaContaining(texto);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<Autor> findByNombreContainingWithPagination(String nombre, Pageable pageable) throws Exception {
        try {
            return autorRepository.findByNombreContainingWithPagination(nombre, pageable);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<Autor> findByNombreAndApellidoWithPagination(String nombre, String apellido, Pageable pageable) throws Exception {
        try {
            return autorRepository.findByNombreAndApellidoWithPagination(nombre, apellido, pageable);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
