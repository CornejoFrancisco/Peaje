package com.demo.Responsitories;

import com.demo.Entities.MarcaTarjetaCredito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarcaTarjetaCredioRespository extends JpaRepository<MarcaTarjetaCredito, Long> {
}
