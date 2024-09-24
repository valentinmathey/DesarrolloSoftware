package com.example.apirest.Service;

import com.example.apirest.Entity.Persona;
import com.example.apirest.Repository.BaseRepository;
import com.example.apirest.Repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaServiceImpl extends BaseServiceImpl<Persona, Long> implements PersonaService{

    @Autowired
    private PersonaRepository personaRepository;

    public PersonaServiceImpl(BaseRepository<Persona, Long> baseRepository) {
        super(baseRepository);
    }

    @Override
    public List<Persona> search(String filtro) throws Exception {
        try {
            List<Persona> personas = personaRepository.findByNombreContainingOrApellidoContaining(filtro, filtro);
            return personas;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<Persona> findByNombreAndApellido(String nombre, String apellido) throws Exception {
        try {
            return personaRepository.findByNombreAndApellido(nombre, apellido);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<Persona> findPersonasConLibros() throws Exception {
        try {
            return personaRepository.findPersonasConLibros();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<Persona> findPersonasByLibroTitulo(String titulo) throws Exception {
        try {
            return personaRepository.findPersonasByLibroTitulo(titulo);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public long countPersonasByDomicilioId(Long domicilioId) throws Exception {
        try {
            return personaRepository.countPersonasByDomicilioId(domicilioId);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<Persona> findPersonasConMultipleLibros() throws Exception {
        try {
            return personaRepository.findPersonasConMultipleLibros();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<Persona> searchJPQL(String filtro) throws Exception {
        try {
            return personaRepository.search(filtro);  // Usando JPQL
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<Persona> searchNativo(String filtro) throws Exception {
        try {
            return personaRepository.searchNativo(filtro);  // Usando SQL Nativo
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<Persona> searchJPQLWithPagination(String filtro, Pageable pageable) throws Exception {
        try {
            return personaRepository.searchJPQLWithPagination(filtro, pageable);  // Usando JPQL
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<Persona> searchNativoWithPagination(String filtro, Pageable pageable) throws Exception {
        try {
            return personaRepository.searchNativoWithPagination(filtro, pageable);  // Usando SQL Nativo
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
