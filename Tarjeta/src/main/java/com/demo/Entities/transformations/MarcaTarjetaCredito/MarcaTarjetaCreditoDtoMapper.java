package com.demo.Entities.transformations.MarcaTarjetaCredito;


import com.demo.Entities.Dto.MarcaTarjetaCreditoDto;
import com.demo.Entities.MarcaTarjetaCredito;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class MarcaTarjetaCreditoDtoMapper implements Function<MarcaTarjetaCredito, MarcaTarjetaCreditoDto> {

    @Override
    public MarcaTarjetaCreditoDto apply(MarcaTarjetaCredito marcaTarjetaCredito){
        return new MarcaTarjetaCreditoDto(
                marcaTarjetaCredito.getId(),
                marcaTarjetaCredito.getNombre()
        );
    }

}
