package com.demo.Entities.transformations.TarjetaCredito;

import com.demo.Entities.Dto.TarjetaCreditoDto;
import com.demo.Entities.TarjetaCredito;
import com.demo.Responsitories.MarcaTarjetaCredioRespository;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class TarjetaCreditoMapper implements Function<TarjetaCreditoDto, TarjetaCredito> {
    private final MarcaTarjetaCredioRespository marcaTarjetaCredioRespository;

    public TarjetaCreditoMapper(MarcaTarjetaCredioRespository tarjetaCredioRespository) {
        this.marcaTarjetaCredioRespository = tarjetaCredioRespository;
    }

    @Override
    public TarjetaCredito apply(TarjetaCreditoDto tarjetaCreditoDto){
        return new TarjetaCredito(
                tarjetaCreditoDto.getId(),
                tarjetaCreditoDto.getFechaExpiracion(),
                tarjetaCreditoDto.getHabilitada(),
                tarjetaCreditoDto.getMotivoTCInhabilitada(),
                tarjetaCreditoDto.getNumero(),
                tarjetaCreditoDto.getMarcaTarjetaCredito()
        );
    }
}
