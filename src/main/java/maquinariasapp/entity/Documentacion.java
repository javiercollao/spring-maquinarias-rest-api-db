package maquinariasapp.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="documentacion")
public class Documentacion {
    @Id
    @Column(name="id_documentacion")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_documentacion;

    @Column(name="tipo_documentacion", length = 30, nullable = false)
    private String tipo_documentacion;
}
