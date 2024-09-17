package com.example.apirest.Controller;

import com.example.apirest.Entity.Autor;
import com.example.apirest.Service.AutorServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/autores")
public class AutorController extends BaseControllerImpl<Autor, AutorServiceImpl>{

}
