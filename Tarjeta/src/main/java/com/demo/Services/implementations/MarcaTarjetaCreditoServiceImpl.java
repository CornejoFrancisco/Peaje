package com.demo.Services.implementations;

import com.demo.Entities.Dto.MarcaTarjetaCreditoDto;
import com.demo.Entities.MarcaTarjetaCredito;
import com.demo.Entities.transformations.MarcaTarjetaCredito.MarcaTarjetaCreditoDtoMapper;
import com.demo.Entities.transformations.MarcaTarjetaCredito.MarcaTarjetaCreditoMapper;
import com.demo.Responsitories.MarcaTarjetaCredioRespository;
import com.demo.Services.MarcaTarjetaCreditoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class MarcaTarjetaCreditoServiceImpl implements MarcaTarjetaCreditoService {
    private final MarcaTarjetaCredioRespository marcaTarjetaCredioRespository;
    private final MarcaTarjetaCreditoMapper marcaTarjetaCreditoMapper;
    private final MarcaTarjetaCreditoDtoMapper marcaTarjetaCreditoDtoMapper;

    public MarcaTarjetaCreditoServiceImpl(MarcaTarjetaCredioRespository marcaTarjetaCredioRespository, MarcaTarjetaCreditoMapper marcaTarjetaCreditoMapper, MarcaTarjetaCreditoDtoMapper marcaTarjetaCreditoDtoMapper) {
        this.marcaTarjetaCredioRespository = marcaTarjetaCredioRespository;
        this.marcaTarjetaCreditoMapper = marcaTarjetaCreditoMapper;
        this.marcaTarjetaCreditoDtoMapper = marcaTarjetaCreditoDtoMapper;
    }

    @Override
    public void add(MarcaTarjetaCreditoDto entity) {
        MarcaTarjetaCredito marcaTarjetaCredito = Optional.of(entity)
                .map(marcaTarjetaCreditoMapper)
                .orElseThrow();
        marcaTarjetaCredioRespository.save(marcaTarjetaCredito);
    }

    @Override
    public void update(MarcaTarjetaCreditoDto entity) {
        Optional<MarcaTarjetaCredito> marcaTarjetaCredito = Stream.of(entity)
                .map(marcaTarjetaCreditoMapper)
                .findAny();
        marcaTarjetaCredito.ifPresent(marcaTarjetaCredioRespository :: save);
    }

    @Override
    public void delete(Long id) {
        Optional<MarcaTarjetaCredito> marcaTarjetaCredito = marcaTarjetaCredioRespository.findById(id);
        marcaTarjetaCredito.ifPresent(marcaTarjetaCredito1 -> marcaTarjetaCredioRespository.delete(marcaTarjetaCredito1));
    }

    @Override
    public MarcaTarjetaCreditoDto getById(Long id) {
        Optional<MarcaTarjetaCredito> marcaTarjetaCredito = marcaTarjetaCredioRespository.findById(id);
        return marcaTarjetaCredito.map(marcaTarjetaCreditoDtoMapper).orElseThrow();
    }

    @Override
    public List<MarcaTarjetaCredito> getAll() {
        List<MarcaTarjetaCredito> marca = marcaTarjetaCredioRespository.findAll();
        return marca;
    }
}
