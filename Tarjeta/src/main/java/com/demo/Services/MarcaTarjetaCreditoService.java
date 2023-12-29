package com.demo.Services;

import com.demo.Entities.Dto.MarcaTarjetaCreditoDto;
import com.demo.Entities.Dto.TarjetaCreditoDto;
import com.demo.Entities.MarcaTarjetaCredito;
import com.demo.Entities.TarjetaCredito;

import java.util.List;

public interface MarcaTarjetaCreditoService {
    void add(MarcaTarjetaCreditoDto entity);
    void update(MarcaTarjetaCreditoDto entity);
    void delete(Long id);
    MarcaTarjetaCreditoDto getById(Long id);
    List<MarcaTarjetaCredito> getAll();
}
