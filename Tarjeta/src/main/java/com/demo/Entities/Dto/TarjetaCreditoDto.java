package com.demo.Entities.Dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TarjetaCreditoDto {
    private long id;
    private Boolean habilitada;
    private Date fechaExpiracion;
    private String motivoTCInhabilitada;
    private String numero;
    private Long marcaTarjetaCredito;

}
