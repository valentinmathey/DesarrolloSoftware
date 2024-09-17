package com.example.apirest.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.envers.Audited;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = false)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "AUTOR")
@Entity
@Audited
public class Autor extends Base{

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "bibliografia", length = 1500)
    private String bibliografia;

    @ManyToMany(mappedBy = "autores")
    private List<Libro> libros = new ArrayList<Libro>();
}
