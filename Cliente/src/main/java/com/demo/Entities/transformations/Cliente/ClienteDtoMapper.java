package com.demo.Entities.transformations.Cliente;

import com.demo.Entities.Cliente;
import com.demo.Entities.DTO.ClienteDto;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class ClienteDtoMapper implements Function<Cliente, ClienteDto> {


    @Override
    public ClienteDto apply(Cliente cliente){
        return new ClienteDto(
                cliente.getId(),
                cliente.getDni(),
                cliente.getApellido(),
                cliente.getNombre(),
                cliente.getTarjetaCredito(),
                cliente.getVehiculo().getId()
        );
    }
}
