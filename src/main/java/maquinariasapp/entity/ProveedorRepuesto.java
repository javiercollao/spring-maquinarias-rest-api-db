package maquinariasapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="proveedor_repuesto")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProveedorRepuesto {
    @Id
    @Column(name="id_prov_rep")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_prov_rep;

    @Column(name="cantidad_repuesto")
    private Integer cantidad_repuesto;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_repuesto")
    private Repuesto repuesto;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_proveedor")
    private Proveedor proveedor;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "ot_repuestos", joinColumns = @JoinColumn(name = "id_prov_rep", referencedColumnName = "id_prov_rep"), inverseJoinColumns = @JoinColumn(name = "id_ot", referencedColumnName = "id_ot"))
    @JsonIgnore
    private List<Ot> ots = new ArrayList<>();

}
