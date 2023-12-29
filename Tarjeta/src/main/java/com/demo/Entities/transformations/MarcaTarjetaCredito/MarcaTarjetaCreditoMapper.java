package com.demo.Entities.transformations.MarcaTarjetaCredito;


import com.demo.Entities.Dto.MarcaTarjetaCreditoDto;
import com.demo.Entities.MarcaTarjetaCredito;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class MarcaTarjetaCreditoMapper implements Function<MarcaTarjetaCreditoDto, MarcaTarjetaCredito> {

    @Override
    public MarcaTarjetaCredito apply(MarcaTarjetaCreditoDto marcaTarjetaCreditoDto){
        return new MarcaTarjetaCredito(
                marcaTarjetaCreditoDto.getId(),
                marcaTarjetaCreditoDto.getNombre()
        );
    }
}
