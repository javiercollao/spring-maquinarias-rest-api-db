package maquinariasapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="proveedor")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Proveedor {
    @Id
    @Column(name="id_proveedor")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_proveedor;

    @Column(name="nombre_proveedor", length = 50, nullable = false)
    private String nombre_proveedor;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "id_prov_rep")
    @JsonIgnore
    private List<ProveedorRepuesto> proveedorRepuestos = new ArrayList<>();

}
