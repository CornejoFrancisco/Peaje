package com.demo.Entities.transformations.Vehiculo;

import com.demo.Entities.CategoriaAutomovil;
import com.demo.Entities.DTO.VehiculoDto;
import com.demo.Entities.Vehiculo;
import com.demo.Respositories.CategoriaAutomovilRespository;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class VehiculoMapper implements Function<VehiculoDto, Vehiculo> {
    private final CategoriaAutomovilRespository categoriaAutomovilRespository;

    public VehiculoMapper(CategoriaAutomovilRespository categoriaAutomovilRespository) {
        this.categoriaAutomovilRespository = categoriaAutomovilRespository;
    }


    @Override
    public Vehiculo apply(VehiculoDto vehiculoDto) {

        return new Vehiculo(
                vehiculoDto.getId(),
                vehiculoDto.getDominio(),
                vehiculoDto.getModelo(),
                categoriaAutomovilRespository.getReferenceById(vehiculoDto.getId())
        );
    }

}
