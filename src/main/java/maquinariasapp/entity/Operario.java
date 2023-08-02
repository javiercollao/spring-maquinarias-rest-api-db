package maquinariasapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="operario")
@Data
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

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "id_ot")
    @JsonIgnore
    private List<Ot> ots = new ArrayList<>();

}
