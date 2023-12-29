package com.demo.Entities.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDto {
    private Long id;
    private Integer dni;
    private String apellido;
    private String nombre;
    private Long tarjetaCredito;
    private Long vehiculo;


}

