package com.demo.Entities.transformations.Cliente;

import com.demo.Entities.Cliente;
import com.demo.Entities.DTO.ClienteDto;
import com.demo.Entities.DTO.TarjetaCreditoDto;
import com.demo.Entities.Vehiculo;
import com.demo.Respositories.VehiculoRespository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.function.Function;


@Service
public class ClienteMapper implements Function<ClienteDto, Cliente> {
    private final TarjetaCreditoDto tarjetaCreditoDto;
    private final VehiculoRespository vehiculoRespository;
    private final RestTemplate restTemplate;

    public ClienteMapper(TarjetaCreditoDto tarjetaCreditoDto, VehiculoRespository vehiculoRespository, RestTemplate restTemplate) {
        this.tarjetaCreditoDto = tarjetaCreditoDto;
        this.vehiculoRespository = vehiculoRespository;
        this.restTemplate = restTemplate;
    }




    @Override
    public Cliente apply(ClienteDto clienteDto) {
        try {
            ResponseEntity<TarjetaCreditoDto> responseEntity = restTemplate.getForEntity(
                    "http://localhost:8083/tarjetaCredito/" + clienteDto.getTarjetaCredito(),
                    TarjetaCreditoDto.class
            );

            if (!responseEntity.getStatusCode().is2xxSuccessful()) {
                // Manejar la respuesta no exitosa si es necesario
                throw new RuntimeException("Error al obtener TarjetaCreditoDto");
            }

            TarjetaCreditoDto tarjetaCreditoDto = responseEntity.getBody();
            long numeroTarjetaCredito = tarjetaCreditoDto.getId();

            Vehiculo vehiculo = vehiculoRespository.getReferenceById(clienteDto.getId());


            return new Cliente(
                    clienteDto.getId(),
                    clienteDto.getDni(),
                    clienteDto.getApellido(),
                    clienteDto.getNombre(),
                    numeroTarjetaCredito,
                    vehiculo
            );
        } catch (RestClientException e) {
            // Manejar la excepción de la llamada a la URL
            throw new RuntimeException("Error en la llamada a la URL", e);
        }
    }



}
