package com.demo.Entities;


import com.demo.Entities.DTO.TarjetaCreditoDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "dni")
    private Integer dni;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "id_tarjeta")
    private Long tarjetaCredito;

    @ManyToOne(cascade = CascadeType.PERSIST, targetEntity = Vehiculo.class)
    @JoinColumn(name = "id_vehiculo")
    private Vehiculo vehiculo;

}
