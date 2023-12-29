package com.demo.Services.Implementations;

import com.demo.Entities.CategoriaAutomovil;
import com.demo.Entities.DTO.CategoriaAutomovilDto;
import com.demo.Entities.Vehiculo;
import com.demo.Entities.transformations.CategoriaAutomovil.CategoriaAutomovilDtoMapper;
import com.demo.Entities.transformations.CategoriaAutomovil.CategoriaAutomovilMapper;
import com.demo.Respositories.CategoriaAutomovilRespository;
import com.demo.Services.CategoriaAutomovilService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class CategoriaAutomovilServiceImpl implements CategoriaAutomovilService {
    private final CategoriaAutomovilRespository categoriaAutomovilRespository;
    private final CategoriaAutomovilDtoMapper categoriaAutomovilDtoMapper;
    private final CategoriaAutomovilMapper categoriaAutomovilMapper;

    public CategoriaAutomovilServiceImpl(CategoriaAutomovilRespository categoriaAutomovilRespository, CategoriaAutomovilDtoMapper categoriaAutomovilDtoMapper, CategoriaAutomovilMapper categoriaAutomovilMapper) {
        this.categoriaAutomovilRespository = categoriaAutomovilRespository;
        this.categoriaAutomovilDtoMapper = categoriaAutomovilDtoMapper;
        this.categoriaAutomovilMapper = categoriaAutomovilMapper;
    }

    @Override
    public void add(CategoriaAutomovilDto entity) {
        CategoriaAutomovil categoriaAutomovil = Optional.of(entity).map(categoriaAutomovilMapper).orElseThrow();
        categoriaAutomovilRespository.save(categoriaAutomovil);
    }

    @Override
    public void update(CategoriaAutomovilDto entity) {
        Optional<CategoriaAutomovil> categoriaAutomovil = Stream.of(entity)
                .map(categoriaAutomovilMapper)
                .findAny();
        categoriaAutomovil.ifPresent(categoriaAutomovilRespository :: save);

    }

    @Override
    public void delete(Long id) {
        Optional<CategoriaAutomovil> categoriaAutomovil = categoriaAutomovilRespository.findById(id);
        categoriaAutomovil.ifPresent(categoriaAutomovil1 -> categoriaAutomovilRespository.delete(categoriaAutomovil1));
    }

    @Override
    public CategoriaAutomovilDto getById(Long id) {
        Optional<CategoriaAutomovil> categoriaAutomovil = categoriaAutomovilRespository.findById(id);
        return categoriaAutomovil.map(categoriaAutomovilDtoMapper).orElseThrow();
    }

    @Override
    public List<CategoriaAutomovilDto> getAll() {
        List<CategoriaAutomovil> categoriaAutomovils = categoriaAutomovilRespository.findAll();
        List<CategoriaAutomovilDto> categoriaAutomovilDtos = categoriaAutomovils.stream()
                .map(categoriaAutomovil -> {
                    CategoriaAutomovilDto categoriaAutomovilDto = new CategoriaAutomovilDto();
                    categoriaAutomovilDto.setId(categoriaAutomovil.getId());
                    categoriaAutomovilDto.setBase(categoriaAutomovil.getBase());
                    categoriaAutomovilDto.setNombre(categoriaAutomovil.getNombre());
                    categoriaAutomovilDto.setUrlImagen(categoriaAutomovil.getUrlImagen());
                    return categoriaAutomovilDto;
                }).toList();
        return categoriaAutomovilDtos;
    }
}
