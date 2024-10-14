package com.example.apirestDTO.Domain.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ErrorDto {

    private String errorMsg; // Mensaje de error
    private String errorClass; // Clase de la excepción que produjo el error
    private long timestamp; // Campo de marca de tiempo añadido para facilitar la depuración
}
