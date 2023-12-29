package com.demo.Entities;

import com.fasterxml.jackson.databind.jsontype.impl.StdTypeResolverBuilder;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Vehiculos")
public class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @TableGenerator(name = "'Vehiculos'", table = "sqlite_sequence",
            pkColumnName = "name", valueColumnName = "seq",
            pkColumnValue="id",
            initialValue=1, allocationSize=1)
    private Long id;

    @Column(name = "dominio")
    private String dominio;

    @Column(name = "modelo")
    private String modelo;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_categoria_automovil")
    private CategoriaAutomovil categoriaAutomovil;
}
