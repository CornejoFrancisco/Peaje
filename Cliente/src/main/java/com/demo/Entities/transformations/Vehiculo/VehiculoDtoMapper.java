package com.demo.Entities.transformations.Vehiculo;

import com.demo.Entities.DTO.VehiculoDto;
import com.demo.Entities.Vehiculo;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class VehiculoDtoMapper implements Function<Vehiculo, VehiculoDto> {
    @Override
    public VehiculoDto apply(Vehiculo vehiculo){
        return new VehiculoDto(
                vehiculo.getId(),
                vehiculo.getDominio(),
                vehiculo.getModelo(),
                vehiculo.getCategoriaAutomovil().getId()
        );
    }
}
