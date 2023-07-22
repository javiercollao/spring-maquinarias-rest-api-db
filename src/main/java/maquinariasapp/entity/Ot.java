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
@Table(name="ot")
public class Ot {

    @Id
    @Column(name="id_ot")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_ot;

    @Column(name="desc_ot", length = 200, nullable = false)
    private String desc_ot;

    @Column(name="fecha_ot")
    private Date fecha_ot;

    @Column(name="proxima_fecha_ot")
    private Date proxima_fecha_ot;

    @Column(name="observacion_ot", length = 30)
    private String observacion_ot;

    @Column(name="clase_mantenimiento_ot", length = 30)
    private String clase_mantenimiento_ot;

}
