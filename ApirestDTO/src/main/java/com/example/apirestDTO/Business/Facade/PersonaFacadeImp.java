package com.example.apirestDTO.Business.Facade;

import com.example.apirestDTO.Business.Mapper.PersonaMapper;
import com.example.apirestDTO.Business.Service.PersonaService;
import com.example.apirestDTO.Domain.Dto.PersonaFullDto;
import com.example.apirestDTO.Domain.Dto.PersonaShortDto;
import org.springframework.beans.factory.annotation.Autowired;

public class PersonaFacadeImp implements PersonaFacade{

    @Autowired
    private PersonaService personaService;
    @Autowired
    private PersonaMapper personaMapper;

    @Override
    public PersonaFullDto crear(PersonaFullDto nuevaPersonaDto) {
        // Convertir el objeto PersonaFullDto en una entidad Persona
        var newPersona = personaMapper.personaFullDtoToPersona(nuevaPersonaDto);

        // Guardar la entidad Persona en la base de datos
        var personaGuardada = personaService.crear(newPersona);

        // Convertir la entidad guardada nuevamente en un objeto PersonaFullDto y devolverlo
        return personaMapper.personaToPersonaFullDto(personaGuardada);
    }

    @Override
    public PersonaFullDto getAllDataById(Long id) {
        // Obtener la entidad Persona desde la base de datos a partir de su ID
        var persona = personaService.getById(id);

        // Convertir la entidad Persona en un objeto PersonaFullDto que contiene todos los datos completos
        return personaMapper.personaToPersonaFullDto(persona);
    }

    @Override
    public PersonaShortDto getShortDataById(Long id) {
        // Obtener la entidad Persona desde la base de datos a partir de su ID
        var persona = personaService.getById(id);

        // Convertir la entidad Persona en un objeto PersonaShortDto que contiene solo algunos datos
        return personaMapper.personaToPersonaShortDto(persona);
    }
}
