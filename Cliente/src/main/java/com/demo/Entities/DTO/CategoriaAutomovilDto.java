package com.demo.Entities.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaAutomovilDto {
    private Long id;
    private String base;
    private String nombre;
    private String urlImagen;
}
