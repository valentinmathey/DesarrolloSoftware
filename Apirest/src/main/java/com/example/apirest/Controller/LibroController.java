package com.example.apirest.Controller;

import com.example.apirest.Entity.Libro;
import com.example.apirest.Service.LibroServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/libros")
public class LibroController extends BaseControllerImpl<Libro, LibroServiceImpl>{
}
