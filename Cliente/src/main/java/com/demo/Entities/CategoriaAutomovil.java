package com.demo.Entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "categoria_automoviles")
public class CategoriaAutomovil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @TableGenerator(name = "'CategoriaAutomoviles'", table = "sqlite_sequence",
            pkColumnName = "name", valueColumnName = "seq",
            pkColumnValue="id",
            initialValue=1, allocationSize=1)
    private Long id;

    @Column(name = "base")
    private String base;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "urlimagen")
    private String urlImagen;
}
