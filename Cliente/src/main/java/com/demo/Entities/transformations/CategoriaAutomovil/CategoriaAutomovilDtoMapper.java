package com.demo.Entities.transformations.CategoriaAutomovil;

import com.demo.Entities.CategoriaAutomovil;
import com.demo.Entities.DTO.CategoriaAutomovilDto;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class CategoriaAutomovilDtoMapper implements Function<CategoriaAutomovil, CategoriaAutomovilDto> {
        @Override
        public CategoriaAutomovilDto apply(CategoriaAutomovil categoriaAutomovil){
            return new CategoriaAutomovilDto(
                    categoriaAutomovil.getId(),
                    categoriaAutomovil.getBase(),
                    categoriaAutomovil.getNombre(),
                    categoriaAutomovil.getUrlImagen()
            );
        }
}
