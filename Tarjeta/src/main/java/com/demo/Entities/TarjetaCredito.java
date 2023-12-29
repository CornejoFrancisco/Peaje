package com.demo.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "TarjetaCreditos")
public class TarjetaCredito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @TableGenerator(name = "TarjetaCreditos", table = "sqlite_sequence",
            pkColumnName = "name", valueColumnName = "seq",
            pkColumnValue="id",
            initialValue=1, allocationSize=1)
    @Column(name = "id")
    private long id;

    @Column(name = "fecha_expiracion")
    private Date fechaExpiracion;

    @Column(name = "habilitada")
    private Boolean habilitada;

    @Column(name = "motivotcinhabilitada")
    private String motivoTCInhabilitada;

    @Column(name = "numero")
    private String numero;

    @Column(name = "id_marca")
    private Long marcaTarjetaCredito;



}
