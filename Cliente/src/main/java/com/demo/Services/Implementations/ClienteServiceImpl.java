package com.demo.Services.Implementations;


import com.demo.Entities.Cliente;
import com.demo.Entities.DTO.ClienteDto;
import com.demo.Entities.DTO.ResponseDto;
import com.demo.Entities.DTO.TarjetaCreditoDto;
import com.demo.Entities.transformations.Cliente.ClienteDtoMapper;
import com.demo.Entities.transformations.Cliente.ClienteMapper;
import com.demo.Respositories.ClienteRespository;
import com.demo.Respositories.VehiculoRespository;
import com.demo.Services.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class ClienteServiceImpl implements ClienteService {
    private final ClienteRespository clienteRespository;
    private final ClienteDtoMapper clienteDtoMapper;
    private final ClienteMapper clienteMapper;
    private final VehiculoRespository vehiculoRespository;
    private final RestTemplate restTemplate;

    public ClienteServiceImpl(ClienteRespository clienteRespository, ClienteDtoMapper clienteDtoMapper, ClienteMapper clienteMapper, VehiculoRespository vehiculoRespository, RestTemplate restTemplate) {
        this.clienteRespository = clienteRespository;
        this.clienteDtoMapper = clienteDtoMapper;
        this.clienteMapper = clienteMapper;
        this.vehiculoRespository = vehiculoRespository;
        this.restTemplate = restTemplate;
    }

    @Override
    public void add(ClienteDto clienteDto) {
        Cliente cliente = new Cliente();
        cliente.setApellido(clienteDto.getApellido());
        cliente.setDni(clienteDto.getDni());
        cliente.setNombre(clienteDto.getNombre());
        cliente.setTarjetaCredito(clienteDto.getTarjetaCredito());
        cliente.setVehiculo(vehiculoRespository.getReferenceById(clienteDto.getVehiculo()));
        clienteRespository.save(cliente);
    }

    @Override
    public void update(ClienteDto clienteDto) {
        Optional<Cliente> cliente = Stream.of(clienteDto)
                .map(clienteMapper)
                .findAny();
        cliente.ifPresent(clienteRespository :: save);
    }

    @Override
    public void delete(Long id) {
        Optional<Cliente> clienteOptional = clienteRespository.findById(id);
        clienteOptional.ifPresent(cliente -> clienteRespository.delete(cliente));
    }


    public ClienteDto getById(Long id) {
        ResponseDto responseDto = new ResponseDto();
        Optional<ClienteDto> clienteOptional = clienteRespository.findById(id).map(clienteDtoMapper).stream().findAny();
        ClienteDto cliente = new ClienteDto();

        if (clienteOptional.isPresent()) {
            cliente = clienteOptional.get();
            ResponseEntity<TarjetaCreditoDto> responseEntity = restTemplate.getForEntity(
                    "http://localhost:8083/tarjetaCredito/" + cliente.getTarjetaCredito(),
                    TarjetaCreditoDto.class);

            TarjetaCreditoDto tarjetaCreditoDto = responseEntity.getBody();
            responseDto.setTarjetaCreditoDto(tarjetaCreditoDto);
        } else {
            throw new NoSuchElementException("Cliente no encontrado con ID: " + id);
        }

        return cliente;


    }

    @Override
    public List<Cliente> getAll() {
        List<Cliente> clientes = clienteRespository.findAll();
        return clientes;
    }

}
