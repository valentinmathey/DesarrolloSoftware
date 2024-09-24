package com.example.apirest.Controller;

import com.example.apirest.Entity.Libro;
import com.example.apirest.Service.LibroServiceImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/libros")
public class LibroController extends BaseControllerImpl<Libro, LibroServiceImpl>{

    @GetMapping("/searchByTitulo")
    public ResponseEntity<?> findByTituloContaining(@RequestParam String titulo) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.findByTituloContaining(titulo));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\": \"" + e.getMessage() + "\"}");
        }
    }

    @GetMapping("/searchByGenero")
    public ResponseEntity<?> findByGenero(@RequestParam String genero) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.findByGenero(genero));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\": \"" + e.getMessage() + "\"}");
        }
    }

    @GetMapping("/searchByFecha")
    public ResponseEntity<?> findByFechaBetween(@RequestParam Date startDate, @RequestParam Date endDate) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.findByFechaBetween(startDate, endDate));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\": \"" + e.getMessage() + "\"}");
        }
    }

    @GetMapping("/countByPersona")
    public ResponseEntity<?> countLibrosByPersonaId(@RequestParam Long personaId) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.countLibrosByPersonaId(personaId));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\": \"" + e.getMessage() + "\"}");
        }
    }

    @GetMapping("/searchByAutor")
    public ResponseEntity<?> findByAutorId(@RequestParam Long autorId) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.findByAutorId(autorId));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\": \"" + e.getMessage() + "\"}");
        }
    }

    @GetMapping("/searchByPaginas")
    public ResponseEntity<?> findByPaginasGreaterThan(@RequestParam int paginas) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.findByPaginasGreaterThan(paginas));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\": \"" + e.getMessage() + "\"}");
        }
    }

    @GetMapping("/searchByTituloPaged")
    public ResponseEntity<?> findByTituloContainingWithPagination(@RequestParam String titulo, Pageable pageable) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.findByTituloContainingWithPagination(titulo, pageable));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\": \"" + e.getMessage() + "\"}");
        }
    }

    @GetMapping("/searchByGeneroPaged")
    public ResponseEntity<?> findByGeneroWithPagination(@RequestParam String genero, Pageable pageable) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.findByGeneroWithPagination(genero, pageable));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\": \"" + e.getMessage() + "\"}");
        }
    }
}
