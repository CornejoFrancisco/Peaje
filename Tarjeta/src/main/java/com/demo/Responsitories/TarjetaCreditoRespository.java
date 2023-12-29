package com.demo.Responsitories;

import com.demo.Entities.TarjetaCredito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarjetaCreditoRespository extends JpaRepository<TarjetaCredito, Long> {
}
