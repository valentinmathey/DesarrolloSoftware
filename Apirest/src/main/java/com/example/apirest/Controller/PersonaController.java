package com.example.apirest.Controller;

import com.example.apirest.Entity.Persona;
import com.example.apirest.Service.PersonaServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/persona")
public class PersonaController extends BaseControllerImpl<Persona, PersonaServiceImpl>{
}
