package com.example.apirestDTO.Business.Facade;

import com.example.apirestDTO.Domain.Dto.PersonaFullDto;
import com.example.apirestDTO.Domain.Dto.PersonaShortDto;

public interface PersonaFacade {

    PersonaFullDto crear(PersonaFullDto nuevaPersonaDto);

    PersonaFullDto getAllDataById(Long id);

    PersonaShortDto getShortDataById(Long id);
}
