package com.demo.Services;

import com.demo.Entities.DTO.ClienteDto;
import com.demo.Entities.DTO.VehiculoDto;
import com.demo.Entities.Vehiculo;

import java.util.List;

public interface VehiculoService {
    void add(VehiculoDto entity);
    void update(VehiculoDto entity);
    void delete(Long id);
    VehiculoDto getById(Long id);
    List<Vehiculo> getAll();
}
