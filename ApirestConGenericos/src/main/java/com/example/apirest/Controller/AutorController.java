package com.example.apirest.Controller;

import com.example.apirest.Entity.Autor;
import com.example.apirest.Service.AutorServiceImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/autores")
public class AutorController extends BaseControllerImpl<Autor, AutorServiceImpl>{

    @GetMapping("/searchByNombre")
    public ResponseEntity<?> findByNombreContaining(@RequestParam String nombre) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.findByNombreContaining(nombre));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\": \"" + e.getMessage() + "\"}");
        }
    }

    @GetMapping("/searchByNombreAndApellido")
    public ResponseEntity<?> findByNombreAndApellido(@RequestParam String nombre, @RequestParam String apellido) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.findByNombreAndApellido(nombre, apellido));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\": \"" + e.getMessage() + "\"}");
        }
    }

    @GetMapping("/searchByLibro")
    public ResponseEntity<?> findByLibroId(@RequestParam Long libroId) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.findByLibroId(libroId));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\": \"" + e.getMessage() + "\"}");
        }
    }

    @GetMapping("/autoresWithMultipleLibros")
    public ResponseEntity<?> findAutoresWithMultipleLibros() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.findAutoresWithMultipleLibros());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\": \"" + e.getMessage() + "\"}");
        }
    }

    @GetMapping("/searchByBibliografia")
    public ResponseEntity<?> findByBibliografiaContaining(@RequestParam String texto) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.findByBibliografiaContaining(texto));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\": \"" + e.getMessage() + "\"}");
        }
    }

    @GetMapping("/searchByNombrePaged")
    public ResponseEntity<?> findByNombreContainingWithPagination(@RequestParam String nombre, Pageable pageable) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.findByNombreContainingWithPagination(nombre, pageable));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\": \"" + e.getMessage() + "\"}");
        }
    }

    @GetMapping("/searchByNombreAndApellidoPaged")
    public ResponseEntity<?> findByNombreAndApellidoWithPagination(@RequestParam String nombre, @RequestParam String apellido, Pageable pageable) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.findByNombreAndApellidoWithPagination(nombre, apellido, pageable));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\": \"" + e.getMessage() + "\"}");
        }
    }

}
