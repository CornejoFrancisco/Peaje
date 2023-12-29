package com.demo.Entities.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class TarjetaCreditoDto {
    private long id;
    private Date fechaExpiracion;
    private Boolean habilitada;
    private String motivoTCInhabilitada;
    private String numero;
    private Long marcaTarjetaCredito;

}
