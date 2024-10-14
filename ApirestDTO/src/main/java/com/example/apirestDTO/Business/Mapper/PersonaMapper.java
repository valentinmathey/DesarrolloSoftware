package com.example.apirestDTO.Business.Mapper;

import com.example.apirestDTO.Domain.Dto.PersonaFullDto;
import com.example.apirestDTO.Domain.Dto.PersonaShortDto;
import com.example.apirestDTO.Domain.Entity.Persona;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PersonaMapper {

    // Convierte un objeto Persona a PersonaFullDto
    PersonaFullDto personaToPersonaFullDto(Persona persona);

    // Convierte un objeto PersonaFullDto a Persona
    Persona personaFullDtoToPersona(PersonaFullDto personaFullDto);

    // Mapea el campo "provincia" desde el objeto "domicilio" de Persona a el campo "provincia" en PersonaShortDto
    @Mapping(source = "domicilio.provincia", target = "provincia")
    PersonaShortDto personaToPersonaShortDto(Persona persona);
}
