package com.example.apirest.Controller;

import com.example.apirest.Entity.Persona;
import com.example.apirest.Service.PersonaServiceImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/persona")
public class PersonaController extends BaseControllerImpl<Persona, PersonaServiceImpl>{

    @GetMapping("/search")
    public ResponseEntity<?> search(@RequestParam String filtro){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.search(filtro));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
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

    @GetMapping("/personasConLibros")
    public ResponseEntity<?> findPersonasWithLibros() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.findPersonasConLibros());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\": \"" + e.getMessage() + "\"}");
        }
    }

    @GetMapping("/searchByLibroTitulo")
    public ResponseEntity<?> findPersonasByLibroTitulo(@RequestParam String titulo) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.findPersonasByLibroTitulo(titulo));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\": \"" + e.getMessage() + "\"}");
        }
    }

    @GetMapping("/countByDomicilio")
    public ResponseEntity<?> countPersonasByDomicilioId(@RequestParam Long domicilioId) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.countPersonasByDomicilioId(domicilioId));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\": \"" + e.getMessage() + "\"}");
        }
    }

    @GetMapping("/personasConMultipleLibros")
    public ResponseEntity<?> findPersonasConMultipleLibros() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.findPersonasConMultipleLibros());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\": \"" + e.getMessage() + "\"}");
        }
    }

    @GetMapping("/searchJPQL")
    public ResponseEntity<?> searchJPQL(@RequestParam String filtro) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.searchJPQL(filtro));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\": \"" + e.getMessage() + "\"}");
        }
    }

    @GetMapping("/searchNativo")
    public ResponseEntity<?> searchNativo(@RequestParam String filtro) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.searchNativo(filtro));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\": \"" + e.getMessage() + "\"}");
        }
    }

    @GetMapping("/searchJPQLPaged")
    public ResponseEntity<?> searchJPQLWithPagination(@RequestParam String filtro, Pageable pageable) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.searchJPQLWithPagination(filtro, pageable));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\": \"" + e.getMessage() + "\"}");
        }
    }

    @GetMapping("/searchNativoPaged")
    public ResponseEntity<?> searchNativoWithPagination(@RequestParam String filtro, Pageable pageable) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.searchNativoWithPagination(filtro, pageable));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\": \"" + e.getMessage() + "\"}");
        }
    }


}
