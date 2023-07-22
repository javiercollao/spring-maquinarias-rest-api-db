package maquinariasapp.entity;

import jakarta.persistence.*;
import lombok.*;
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="repuesto")
public class Repuesto {
    @Id
    @Column(name="id_repuesto")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_repuesto;

    @Column(name="desc_repuesto", length = 30, nullable = false)
    private String desc_repuesto;

    @Column(name="cantidad_repuesto", nullable = false)
    private Integer cantidad_repuesto;

}
