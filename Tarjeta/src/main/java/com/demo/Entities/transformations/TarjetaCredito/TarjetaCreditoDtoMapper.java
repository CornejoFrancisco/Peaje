package com.demo.Entities.transformations.TarjetaCredito;

import com.demo.Entities.Dto.TarjetaCreditoDto;
import com.demo.Entities.TarjetaCredito;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class TarjetaCreditoDtoMapper implements Function<TarjetaCredito, TarjetaCreditoDto> {
    @Override
    public TarjetaCreditoDto apply(TarjetaCredito tarjetaCredito){
        return new TarjetaCreditoDto(
                tarjetaCredito.getId(),
                tarjetaCredito.getHabilitada(),
                tarjetaCredito.getFechaExpiracion(),
                tarjetaCredito.getMotivoTCInhabilitada(),
                tarjetaCredito.getNumero(),
                tarjetaCredito.getMarcaTarjetaCredito()
        );
    }
}
