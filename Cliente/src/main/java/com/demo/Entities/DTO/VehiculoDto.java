package com.demo.Entities.DTO;

import com.demo.Entities.CategoriaAutomovil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehiculoDto {
    private Long id;
    private String dominio;
    private String modelo;
    private Long categoriaAutomovil;
}
