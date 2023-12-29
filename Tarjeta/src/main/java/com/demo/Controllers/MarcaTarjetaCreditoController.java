package com.demo.Controllers;


import com.demo.Entities.Dto.MarcaTarjetaCreditoDto;
import com.demo.Entities.MarcaTarjetaCredito;
import com.demo.Services.MarcaTarjetaCreditoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.spring.web.readers.operation.ResponseMessagesReader;

import javax.swing.plaf.SpinnerUI;
import java.util.List;
import java.util.ResourceBundle;

@RestController
@RequestMapping("/marcatarjeta")
public class MarcaTarjetaCreditoController {
    private final MarcaTarjetaCreditoService marcaTarjetaCreditoService;

    public MarcaTarjetaCreditoController(MarcaTarjetaCreditoService marcaTarjetaCreditoService) {
        this.marcaTarjetaCreditoService = marcaTarjetaCreditoService;
    }

    @GetMapping
    public ResponseEntity<List<MarcaTarjetaCredito>> getAll(){
        List<MarcaTarjetaCredito> marcaTarjetaCreditos = marcaTarjetaCreditoService.getAll();
        return ResponseEntity.ok(marcaTarjetaCreditos);
    }

    @PostMapping
    public ResponseEntity<Void> add(@RequestBody MarcaTarjetaCreditoDto entity){
        marcaTarjetaCreditoService.add(entity);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody MarcaTarjetaCreditoDto entity){
        marcaTarjetaCreditoService.update(entity);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @GetMapping("/{id}")
    public ResponseEntity<MarcaTarjetaCreditoDto> getById(@PathVariable("id") Long id){
        MarcaTarjetaCreditoDto marcaTarjetaCredito = marcaTarjetaCreditoService.getById(id);
        return ResponseEntity.ok(marcaTarjetaCredito);
    }
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        marcaTarjetaCreditoService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
