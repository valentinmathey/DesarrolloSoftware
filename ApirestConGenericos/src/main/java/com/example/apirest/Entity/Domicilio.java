package com.example.apirest.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.envers.Audited;

@EqualsAndHashCode(callSuper = false)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "DOMICILIO")
@Entity
@Audited
public class Domicilio extends Base{

    @Column(name = "calle")
    private String calle;

    @Column(name = "numero")
    private int numero;

    @ManyToOne(optional = false)
    @JoinColumn(name = "localidad_id")
    private Localidad localidad;

}
