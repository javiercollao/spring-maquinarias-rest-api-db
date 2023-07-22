package maquinariasapp.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="maquinaria")
public class Maquinaria {
    @Id
    @Column(name="id_maquinaria")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_maquinaria;

    @Column(name="cod_maquinaria", length = 30, nullable = false)
    private String cod_maquinaria;

    @Column(name="nombre_maquinaria", length = 20)
    private String nombre_maquinaria;

    @Column(name="tipo_maquinaria", length = 20)
    private String tipo_maquinaria;

    @Column(name="fecha_ingreso_maquinaria", length = 20)
    private Date fecha_ingreso_maquinaria;

    @Column(name="precio_compra_maquinaria", length = 20)
    private String precio_compra_maquinaria;

    @Column(name="frecuencia_mantenimiento_maquinaria", length = 20)
    private String frecuencia_mantenimiento_maquinaria;

    @Column(name="horometro_maquinaria", length = 20)
    private String horometro_maquinaria;

}
