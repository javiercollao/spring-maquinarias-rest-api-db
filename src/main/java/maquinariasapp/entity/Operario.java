package maquinariasapp.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="operario")
public class Operario {
    @Id
    @Column(name="id_operario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_operario;

    @Column(name="cod_operario", length = 30, nullable = false)
    private String cod_operario;

    @Column(name="nombre_operario", length = 20)
    private String nombre_operario;

    @Column(name="apellido_operario", length = 20)
    private String apellido_operario;

    @Column(name="cargo_operario", length = 13)
    private String cargo_operario;

}
