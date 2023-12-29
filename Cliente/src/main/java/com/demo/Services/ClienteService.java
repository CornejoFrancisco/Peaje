package com.demo.Services;

import com.demo.Entities.Cliente;
import com.demo.Entities.DTO.ClienteDto;
import com.demo.Entities.DTO.ResponseDto;

import java.util.List;

public interface ClienteService {
    void add(ClienteDto clienteDto);
    void update(ClienteDto clienteDto);
    void delete(Long id);
    ResponseDto getById(Long id);
    List<Cliente> getAll();

}
