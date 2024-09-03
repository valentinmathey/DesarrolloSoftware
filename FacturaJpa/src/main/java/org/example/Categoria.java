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
@Table(name = "Categoria")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String denominacion;

    @ManyToMany(mappedBy = "categorias")
    @EqualsAndHashCode.Exclude  // Evita la recursión en equals() y hashCode()
    @ToString.Exclude // Evita la recursión en toString()
    @Builder.Default
    private Set<Articulo> articulos = new HashSet<>();

}
