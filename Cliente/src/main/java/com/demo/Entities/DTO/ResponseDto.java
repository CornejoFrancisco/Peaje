package com.demo.Entities.DTO;


import com.demo.Entities.Cliente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDto {
    private Cliente cliente;
    private TarjetaCreditoDto tarjetaCreditoDto;
}
