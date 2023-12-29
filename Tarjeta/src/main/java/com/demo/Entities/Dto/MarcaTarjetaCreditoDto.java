package com.demo.Entities.Dto;

import jakarta.persistence.Column;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MarcaTarjetaCreditoDto {
    private Long id;
    private String nombre;

}
