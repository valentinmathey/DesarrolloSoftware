package com.example.apirestDTO.Domain.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DomicilioDto {

    private Long id;
    private String calle;
    private int numero;
    private String provincia;
}
