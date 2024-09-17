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
@Table(name = "LOCALIDAD")
@Entity
@Audited
public class Localidad extends Base{

    @Column(name = "denominacion")
    private String denominacion;

    @OneToMany(mappedBy = "localidad", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Domicilio> libros = new ArrayList<Domicilio>();
}
