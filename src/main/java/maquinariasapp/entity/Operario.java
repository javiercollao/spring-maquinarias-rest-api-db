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

    @Column(name="correo_operario", length = 30, nullable = false)
    private String correo_operario;

    @Column(name="nombre_operario", length = 20)
    private String nombre_operario;

    @Column(name="apellido_operario", length = 20)
    private String apellido_operario;

    @Column(name="cargo_operario", length = 30)
    private String cargo_operario;

}
