package com.demo.Entities.transformations.CategoriaAutomovil;

import com.demo.Entities.CategoriaAutomovil;
import com.demo.Entities.DTO.CategoriaAutomovilDto;
import com.demo.Entities.DTO.VehiculoDto;
import com.demo.Entities.Vehiculo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.function.Function;
@Service

public class CategoriaAutomovilMapper implements Function<CategoriaAutomovilDto, CategoriaAutomovil>{


    @Override
    public CategoriaAutomovil apply(CategoriaAutomovilDto categoriaAutomovilDto){
        return new CategoriaAutomovil(
                categoriaAutomovilDto.getId(),
                categoriaAutomovilDto.getBase(),
                categoriaAutomovilDto.getNombre(),
                categoriaAutomovilDto.getUrlImagen()
        );
    }
}
