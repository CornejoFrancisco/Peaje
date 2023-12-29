package com.demo.Services.Implementations;

import com.demo.Entities.DTO.VehiculoDto;
import com.demo.Entities.Vehiculo;
import com.demo.Entities.transformations.Vehiculo.VehiculoDtoMapper;
import com.demo.Entities.transformations.Vehiculo.VehiculoMapper;
import com.demo.Respositories.VehiculoRespository;
import com.demo.Services.VehiculoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class VehiculoServiceImpl implements VehiculoService {
    private final VehiculoMapper vehiculoMapper;
    private final VehiculoRespository vehiculoRespository;
    private final VehiculoDtoMapper vehiculoDtoMapper;

    public VehiculoServiceImpl(VehiculoMapper vehiculoMapper, VehiculoRespository vehiculoRespository, VehiculoDtoMapper vehiculoDtoMapper) {
        this.vehiculoMapper = vehiculoMapper;
        this.vehiculoRespository = vehiculoRespository;
        this.vehiculoDtoMapper = vehiculoDtoMapper;
    }

    @Override
    public void add(VehiculoDto entity) {
        Vehiculo vehiculo = Optional.of(entity).map(vehiculoMapper).orElseThrow();
        vehiculoRespository.save(vehiculo);

    }

    @Override
    public void update(VehiculoDto entity) {
        Optional<Vehiculo> vehiculo = Stream.of(entity)
                .map(vehiculoMapper)
                .findAny();
        vehiculo.ifPresent(vehiculoRespository :: save);
    }

    @Override
    public void delete(Long id) {
        Optional<Vehiculo> vehiculo = vehiculoRespository.findById(id);
        vehiculo.ifPresent(vehiculo1 -> vehiculoRespository.delete(vehiculo1));
    }

    @Override
    public VehiculoDto getById(Long id) {
        Optional<Vehiculo> vehiculo = vehiculoRespository.findById(id);
        return vehiculo.map(vehiculoDtoMapper).orElseThrow();
    }

    @Override
    public List<Vehiculo> getAll() {
        List<Vehiculo> vehiculos = vehiculoRespository.findAll();

        return vehiculos;
    }
}
