package com.demo.Respositories;
import com.demo.Entities.CategoriaAutomovil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaAutomovilRespository extends JpaRepository<CategoriaAutomovil, Long> {
}
