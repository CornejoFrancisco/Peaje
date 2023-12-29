package com.demo.Controllers;

import com.demo.Entities.CategoriaAutomovil;
import com.demo.Entities.DTO.CategoriaAutomovilDto;
import com.demo.Services.CategoriaAutomovilService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoriaAuto")
public class CategoriaAutomovilController {
    private final CategoriaAutomovilService categoriaAutomovilService;

    public CategoriaAutomovilController(CategoriaAutomovilService categoriaAutomovilService) {
        this.categoriaAutomovilService = categoriaAutomovilService;
    }

    @GetMapping
    public ResponseEntity<List<CategoriaAutomovilDto>> getAll(){
        List<CategoriaAutomovilDto> categoriaAutomovilList = categoriaAutomovilService.getAll();
        return ResponseEntity.ok(categoriaAutomovilList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaAutomovilDto> getById(@PathVariable("id") Long id){
        CategoriaAutomovilDto categoriaAutomovil = categoriaAutomovilService.getById(id);
        return ResponseEntity.ok(categoriaAutomovil);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<CategoriaAutomovilDto> delete(@PathVariable("id") Long id){
        categoriaAutomovilService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping
    public ResponseEntity<Void> add(@RequestBody CategoriaAutomovilDto entity){
        categoriaAutomovilService.add(entity);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody CategoriaAutomovilDto entity){
        categoriaAutomovilService.update(entity);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
