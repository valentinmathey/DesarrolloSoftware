package com.example.apirest.Service;

import com.example.apirest.Entity.Libro;
import com.example.apirest.Repository.BaseRepository;
import com.example.apirest.Repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class LibroServiceImpl extends BaseServiceImpl<Libro, Long> implements LibroService{

    @Autowired
    private LibroRepository libroRepository;


    public LibroServiceImpl(BaseRepository<Libro, Long> baseRepository) {
        super(baseRepository);
    }

    @Override
    public List<Libro> findByTituloContaining(String titulo) throws Exception {
        try {
            return libroRepository.findByTituloContaining(titulo);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<Libro> findByGenero(String genero) throws Exception {
        try {
            return libroRepository.findByGenero(genero);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<Libro> findByFechaBetween(Date startDate, Date endDate) throws Exception {
        try {
            return libroRepository.findByFechaBetween(startDate, endDate);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public long countLibrosByPersonaId(Long personaId) throws Exception {
        try {
            return libroRepository.countLibrosByPersonaId(personaId);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<Libro> findByAutorId(Long autorId) throws Exception {
        try {
            return libroRepository.findByAutorId(autorId);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<Libro> findByPaginasGreaterThan(int paginas) throws Exception {
        try {
            return libroRepository.findByPaginasGreaterThan(paginas);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<Libro> findByTituloContainingWithPagination(String titulo, Pageable pageable) throws Exception {
        try {
            return libroRepository.findByTituloContainingWithPagination(titulo, pageable);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<Libro> findByGeneroWithPagination(String genero, Pageable pageable) throws Exception {
        try {
            return libroRepository.findByGeneroWithPagination(genero, pageable);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
