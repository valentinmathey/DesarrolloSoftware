package com.example.apirest.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.envers.Audited;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
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

    @Column(name = "bibliografia")
    private String bibliografia;

    @ManyToMany(mappedBy = "autores")
    @EqualsAndHashCode.Exclude  // Evita la recursión en equals() y hashCode()
    @ToString.Exclude
    private List<Libro> libros = new ArrayList<Libro>();
}
