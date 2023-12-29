package com.demo.Controllers;

import com.demo.Entities.Cliente;
import com.demo.Entities.DTO.ClienteDto;
import com.demo.Entities.DTO.ResponseDto;
import com.demo.Entities.transformations.Cliente.ClienteDtoMapper;
import com.demo.Entities.transformations.Cliente.ClienteMapper;
import com.demo.Services.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> getAll() {
        List<Cliente> clientes = clienteService.getAll();
        return ResponseEntity.ok(clientes);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<ClienteDto> delete(@PathVariable("id") Long id){
        clienteService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/cliente/{id}")
    public ResponseEntity<ResponseDto> getById(@PathVariable("id") Long id) {
        ResponseDto responseDto = clienteService.getById(id);
        return ResponseEntity.ok(responseDto);
    }


    @PostMapping
    public ResponseEntity<Void> add(@RequestBody ClienteDto entity){
        clienteService.add(entity);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody ClienteDto entity){
        clienteService.update(entity);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
