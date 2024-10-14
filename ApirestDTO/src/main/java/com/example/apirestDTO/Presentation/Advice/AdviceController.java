package com.example.apirestDTO.Presentation.Advice;

import com.example.apirestDTO.Domain.Dto.ErrorDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@ControllerAdvice
public class AdviceController {

    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ErrorDto> handleException(Exception e){
        String errorMsg = e.getClass().getSimpleName() + " : " + e.getMessage();

        // Registrando el error utilizando la anotación @Slf4j de Lombok
        log.error(errorMsg, e);

        // Devolviendo los detalles del error de manera estructurada
        return ResponseEntity.internalServerError()
                .body(ErrorDto.builder()
                        .errorMsg(e.getMessage()) // Mensaje del error
                        .errorClass(e.getClass().getSimpleName()) // Clase de la excepción
                        .timestamp(System.currentTimeMillis()) // Añadiendo una marca de tiempo
                        .build());
    }
}
