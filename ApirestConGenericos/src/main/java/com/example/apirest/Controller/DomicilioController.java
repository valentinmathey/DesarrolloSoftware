package com.example.apirest.Controller;

import com.example.apirest.Entity.Domicilio;
import com.example.apirest.Service.DomicilioServiceImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/domicilios")
public class DomicilioController extends BaseControllerImpl<Domicilio, DomicilioServiceImpl>{

    @GetMapping("/searchByCalle")
    public ResponseEntity<?> findByCalleContaining(@RequestParam String calle) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.findByCalleContaining(calle));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\": \"" + e.getMessage() + "\"}");
        }
    }

    @GetMapping("/searchByNumero")
    public ResponseEntity<?> findByNumero(@RequestParam int numero) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.findByNumero(numero));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\": \"" + e.getMessage() + "\"}");
        }
    }

    @GetMapping("/searchByLocalidad")
    public ResponseEntity<?> findByLocalidadId(@RequestParam Long localidadId) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.findByLocalidadId(localidadId));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\": \"" + e.getMessage() + "\"}");
        }
    }

    @GetMapping("/countByLocalidad")
    public ResponseEntity<?> countDomiciliosByLocalidadId(@RequestParam Long localidadId) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.countDomiciliosByLocalidadId(localidadId));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\": \"" + e.getMessage() + "\"}");
        }
    }

    @GetMapping("/searchByCallePaged")
    public ResponseEntity<?> findByCalleContainingWithPagination(@RequestParam String calle, Pageable pageable) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.findByCalleContainingWithPagination(calle, pageable));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\": \"" + e.getMessage() + "\"}");
        }
    }

    @GetMapping("/searchByLocalidadPaged")
    public ResponseEntity<?> findByLocalidadIdWithPagination(@RequestParam Long localidadId, Pageable pageable) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.findByLocalidadIdWithPagination(localidadId, pageable));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\": \"" + e.getMessage() + "\"}");
        }
    }
}
