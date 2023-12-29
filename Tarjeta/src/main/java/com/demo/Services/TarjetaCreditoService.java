package com.demo.Services;

import com.demo.Entities.Dto.TarjetaCreditoDto;
import com.demo.Entities.TarjetaCredito;

import java.util.List;

public interface TarjetaCreditoService {
    void add(TarjetaCreditoDto entity);
    void update(TarjetaCreditoDto entity);
    void delete(Long id);
    TarjetaCredito getById(Long id);
    List<TarjetaCredito> getAll();

}
