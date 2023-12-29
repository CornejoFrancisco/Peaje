package com.demo.Controllers;

import com.demo.Entities.Dto.TarjetaCreditoDto;
import com.demo.Entities.TarjetaCredito;
import com.demo.Services.TarjetaCreditoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.login.CredentialException;
import java.util.List;

@RestController
@RequestMapping("/tarjetaCredito")
public class TarjetaCreditoController {

    private final TarjetaCreditoService tarjetaCreditoService;

    public TarjetaCreditoController(TarjetaCreditoService tarjetaCreditoService) {
        this.tarjetaCreditoService = tarjetaCreditoService;
    }

    @GetMapping
    public ResponseEntity<List<TarjetaCredito>> getAll(){
        List<TarjetaCredito> tarjetaCreditos = tarjetaCreditoService.getAll();
        return ResponseEntity.ok(tarjetaCreditos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TarjetaCredito> getById(@PathVariable("id") Long id){
        TarjetaCredito tarjetaCredito = tarjetaCreditoService.getById(id);
        return ResponseEntity.ok(tarjetaCredito);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<TarjetaCreditoDto> delete(@PathVariable("id") Long id){
        tarjetaCreditoService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping
    public ResponseEntity<Void> add(@RequestBody TarjetaCreditoDto entity){
        tarjetaCreditoService.add(entity);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody TarjetaCreditoDto entity){
        tarjetaCreditoService.update(entity);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
