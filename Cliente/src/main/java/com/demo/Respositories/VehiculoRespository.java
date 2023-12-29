package com.demo.Respositories;

import com.demo.Entities.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehiculoRespository extends JpaRepository<Vehiculo, Long> {
}
