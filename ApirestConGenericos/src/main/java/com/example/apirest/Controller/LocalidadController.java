package com.example.apirest.Controller;

import com.example.apirest.Entity.Localidad;
import com.example.apirest.Service.LocalidadServiceImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/localidades")
public class LocalidadController extends BaseControllerImpl<Localidad, LocalidadServiceImpl>{

    @GetMapping("/searchByDenominacion")
    public ResponseEntity<?> findByDenominacionContaining(@RequestParam String denominacion) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.findByDenominacionContaining(denominacion));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\": \"" + e.getMessage() + "\"}");
        }
    }

    @GetMapping("/countDomicilios")
    public ResponseEntity<?> countDomiciliosByLocalidadId(@RequestParam Long localidadId) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.countDomiciliosByLocalidadId(localidadId));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\": \"" + e.getMessage() + "\"}");
        }
    }

    @GetMapping("/localidadesWithoutDomicilios")
    public ResponseEntity<?> findLocalidadesWithoutDomicilios() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.findLocalidadesWithoutDomicilios());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\": \"" + e.getMessage() + "\"}");
        }
    }

    @GetMapping("/searchByDenominacionPaged")
    public ResponseEntity<?> findByDenominacionContainingWithPagination(@RequestParam String denominacion, Pageable pageable) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.findByDenominacionContainingWithPagination(denominacion, pageable));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\": \"" + e.getMessage() + "\"}");
        }
    }
}
