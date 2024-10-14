package com.example.apirestDTO.Domain.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonaShortDto {

    private String nombre;
    private String apellido;
    private String provincia;
}
