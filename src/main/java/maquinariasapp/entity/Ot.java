package maquinariasapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="ot")
@Data
public class Ot {

    @Id
    @Column(name="id_ot")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_ot;

    @Column(name="desc_ot", length = 200, nullable = false)
    private String desc_ot;

    @Column(name="fecha_ot")
    private LocalDateTime fecha_ot;

    @Column(name="proxima_fecha_ot")
    private LocalDateTime proxima_fecha_ot;

    @Column(name="observacion_ot", length = 50)
    private String observacion_ot;

    @Column(name="clase_mantenimiento_ot", length = 50)
    private String clase_mantenimiento_ot;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_operario")
    private Operario operario;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_maquinaria")
    private Maquinaria maquinaria;

    @ManyToMany(mappedBy = "ots", cascade = CascadeType.PERSIST)
    @JsonIgnore
    private List<ProveedorRepuesto> proveedorRepuestos = new ArrayList<>();

}
