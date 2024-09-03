package org.example;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "Cliente")
public class Cliente {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    private String apellido;
    private int dni;
    private String nombre;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_domicilio")
    private Domicilio domicilio;


}
