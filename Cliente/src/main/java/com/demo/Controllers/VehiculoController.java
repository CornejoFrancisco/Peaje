package com.demo.Controllers;


import com.demo.Entities.DTO.VehiculoDto;
import com.demo.Entities.Vehiculo;
import com.demo.Services.VehiculoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.PreparedStatement;
import java.util.List;

@RestController
@RequestMapping("/vehiculo")
public class VehiculoController {
    private final VehiculoService vehiculoService;

    public VehiculoController(VehiculoService vehiculoService) {
        this.vehiculoService = vehiculoService;
    }

    @GetMapping
    public ResponseEntity<List<Vehiculo>> getAll() {
        List<Vehiculo> vehiculoList = vehiculoService.getAll();
        return ResponseEntity.ok(vehiculoList);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<VehiculoDto> delete(@PathVariable("id") Long id){
        vehiculoService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping("/agregar")
    public ResponseEntity<Void> add(@RequestBody VehiculoDto entity){
        vehiculoService.add(entity);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @PutMapping("/modificar")
    public ResponseEntity<Void> update(@RequestBody VehiculoDto entity){
        vehiculoService.update(entity);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
