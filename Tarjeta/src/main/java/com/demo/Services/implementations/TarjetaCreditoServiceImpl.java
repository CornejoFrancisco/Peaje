package com.demo.Services.implementations;

import com.demo.Entities.Dto.TarjetaCreditoDto;
import com.demo.Entities.TarjetaCredito;
import com.demo.Entities.transformations.TarjetaCredito.TarjetaCreditoDtoMapper;
import com.demo.Entities.transformations.TarjetaCredito.TarjetaCreditoMapper;
import com.demo.Responsitories.TarjetaCreditoRespository;
import com.demo.Services.TarjetaCreditoService;
import com.fasterxml.jackson.annotation.OptBoolean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class TarjetaCreditoServiceImpl implements TarjetaCreditoService {
    private final TarjetaCreditoRespository tarjetaCreditoRespository;
    private final TarjetaCreditoMapper tarjetaCreditoMapper;
    private final TarjetaCreditoDtoMapper tarjetaCreditoDtoMapper;

    public TarjetaCreditoServiceImpl(TarjetaCreditoRespository tarjetaCreditoRespository, TarjetaCreditoMapper tarjetaCreditoMapper, TarjetaCreditoDtoMapper tarjetaCreditoDtoMapper) {
        this.tarjetaCreditoRespository = tarjetaCreditoRespository;
        this.tarjetaCreditoMapper = tarjetaCreditoMapper;
        this.tarjetaCreditoDtoMapper = tarjetaCreditoDtoMapper;
    }

    @Override
    public void add(TarjetaCreditoDto entity) {
        TarjetaCredito tarjetaCredito = Optional.of(entity).map(tarjetaCreditoMapper).orElseThrow();
        tarjetaCreditoRespository.save(tarjetaCredito);
    }

    @Override
    public void update(TarjetaCreditoDto entity) {
        Optional<TarjetaCredito> tarjetaCredito = Stream.of(entity)
                .map(tarjetaCreditoMapper)
                .findAny();
        tarjetaCredito.ifPresent(tarjetaCreditoRespository :: save);
    }

    @Override
    public void delete(Long id) {
        Optional<TarjetaCredito> tarjetaCredito = tarjetaCreditoRespository.findById(id);
        tarjetaCredito.ifPresent(tarjetaCredito1 -> tarjetaCreditoRespository.delete(tarjetaCredito1));
    }

    @Override
    public TarjetaCredito getById(Long id) {
        Optional<TarjetaCredito> tarjetaCredito= tarjetaCreditoRespository.findById(id);
        return tarjetaCredito.orElse(null);

    }

    @Override
    public List<TarjetaCredito> getAll() {
        List<TarjetaCredito> tarjetaCreditos = tarjetaCreditoRespository.findAll();
        return tarjetaCreditos;
    }
}
