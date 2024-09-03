package org.example;

import javax.persistence.*;
import lombok.*;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "Articulo")
public class Articulo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int cantidad;
    private String denominacion;
    private int precio;

    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinTable(name = "articulo_categoria",
            joinColumns = @JoinColumn(name = "articulo_id"),
            inverseJoinColumns = @JoinColumn(name = "categoria_id"))
    @Builder.Default
    private Set<Categoria> categorias= new HashSet<>();
}