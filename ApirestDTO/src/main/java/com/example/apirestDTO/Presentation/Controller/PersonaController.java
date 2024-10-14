package com.example.apirestDTO.Presentation.Controller;


import com.example.apirestDTO.Business.Facade.PersonaFacade;
import com.example.apirestDTO.Domain.Dto.PersonaFullDto;
import com.example.apirestDTO.Domain.Dto.PersonaShortDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/persona")
public class PersonaController {

    @Autowired
    private PersonaFacade personaFacade;

    @GetMapping("/all/{id}")
    public ResponseEntity<PersonaFullDto> getAllDataById(@PathVariable Long id){
        return ResponseEntity.ok().body(personaFacade.getAllDataById(id));
    }

    @GetMapping("/short/{id}")
    public ResponseEntity<PersonaShortDto> getShortDataById(@PathVariable Long id){
        return ResponseEntity.ok().body(personaFacade.getShortDataById(id));
    }

    @PostMapping("/")
    public ResponseEntity<PersonaFullDto> crear(@RequestBody PersonaFullDto personaFullDto){
        return ResponseEntity.ok().body(personaFacade.crear(personaFullDto));
    }
}
