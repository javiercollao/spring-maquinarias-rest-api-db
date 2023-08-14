package maquinariasapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="repuesto")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Repuesto {
    @Id
    @Column(name="id_repuesto")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_repuesto;

    @Column(name="desc_repuesto", nullable = false)
    private String desc_repuesto;

    @Column(name="nombre_repuesto", length = 70, nullable = false)
    private String nombre_repuesto;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "id_prov_rep")
    @JsonIgnore
    private List<ProveedorRepuesto> proveedorRepuestos = new ArrayList<>();

}
