package maquinariasapp.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="proveedor_repuesto")
public class ProveedorRepuesto {
    @Id
    @Column(name="id_prov_rep")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_prov_rep;

    @Column(name="precio_prov_rep", nullable = false)
    private Integer precio_prov_rep;

}
