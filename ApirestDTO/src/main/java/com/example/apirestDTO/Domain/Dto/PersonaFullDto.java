package com.example.apirestDTO.Domain.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonaFullDto {

    private Long id;
    private String nombre;
    private String apellido;
    private int edad;
    private Date fechaNacimiento;
    private DomicilioDto domicilio;
}
