package com.demo.Services;

import com.demo.Entities.DTO.CategoriaAutomovilDto;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CategoriaAutomovilService {
    void add(CategoriaAutomovilDto entity);
    void update(CategoriaAutomovilDto entity);
    void delete(Long id);
    CategoriaAutomovilDto getById(Long id);
    List<CategoriaAutomovilDto> getAll();
}
