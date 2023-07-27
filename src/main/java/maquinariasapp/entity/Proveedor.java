package maquinariasapp.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="proveedor")
public class Proveedor {
    @Id
    @Column(name="id_proveedor")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_proveedor;

    @Column(name="nombre_proveedor", length = 50, nullable = false)
    private String nombre_proveedor;

}
