package org.example.Entity;

import javax.persistence.*;
import lombok.*;
import org.hibernate.envers.Audited;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "Categoria")
@Audited
public class Categoria implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "denominacion")
    private String denominacion;

    @ManyToMany(mappedBy = "categorias")
    @EqualsAndHashCode.Exclude  // Evita la recursión en equals() y hashCode()
    @ToString.Exclude // Evita la recursión en toString()
    @Builder.Default
    private List<Articulo> articulos = new ArrayList<Articulo>();

}
